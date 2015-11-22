package com.github.hjuergens.logback.excel;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.Layout;
import com.github.hjuergens.logback.excel.encoding.ExcelEncoder;
import org.apache.poi.ss.util.WorkbookUtil;

import java.nio.charset.Charset;


public class ExcelAppender<E> extends FileAppender<E> {

    protected String password = "";
    protected String sheetName = "logback";
    protected Layout<E> layout;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        try {
            WorkbookUtil.validateSheetName(sheetName);
        } catch (Exception e) {
            addError("invalid sheet name", e);
        }
        this.sheetName = sheetName;
    }

    /**
     * If the value of <b>File</b> is not <code>null</code>, then
     * {@link #openFile} is called with the values of <b>File</b> and
     * <b>Append</b> properties.
     */
    public void start() {
        super.start();
        init();
    }

    public void setLayout(Layout<E> layout) {
        super.setLayout(layout);
        this.layout = layout;
    }

    private void init() {
        ExcelEncoder<E> lwe = new ExcelEncoder<>();
        lwe.setLayout(layout);
        lwe.setCharset(Charset.forName("UTF-8"));
        lwe.setContext(this.context);
        lwe.setFileName(this.fileName);
        lwe.setSheetName(this.sheetName);
        lwe.setPassword(this.password);
        this.encoder = lwe;
    }


}
