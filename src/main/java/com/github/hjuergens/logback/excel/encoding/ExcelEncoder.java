package com.github.hjuergens.logback.excel.encoding;

import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 */
public class ExcelEncoder<E> extends LayoutWrappingEncoder<E> {

    private Workbook workbook;
    private String fileName;
    private String password;
    private String sheetName;

    public ExcelEncoder() {
    }

    @Override
    public void init(OutputStream os) throws IOException {
        super.init(os);
        try {
            File file = new File(fileName);
            workbook = WorkbookFactory.create(file, password);
            workbook.createSheet(sheetName);
            WorkbookUtil.createSafeSheetName(fileName);
            this.context.putObject("workbench", workbook);
        } catch (InvalidFormatException e) {
            workbook = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
            this.context.putObject("workbench", workbook);
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public void doEncode(E event) throws IOException {
        String val = layout.doLayout(event);

            /*
            Sheet sh = wb.createSheet();
            for(int rownum = 0; rownum < 1000; rownum++){
                Row row = sh.createRow(rownum);
                for(int cellnum = 0; cellnum < 10; cellnum++){
                    Cell cell = row.createCell(cellnum);
                    String address = new CellReference(cell).formatAsString();
                    cell.setCellValue(address);
                }
            }
            */

        outputStream.write(val.getBytes());
        // necessary if ResilientFileOutputStream is buffered
        outputStream.flush();
    }

    @Override
    public void close() throws IOException {
        workbook.write(outputStream);
        this.outputStream.close();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

