package net.sf.hajuergens;

import net.sf.jett.transform.ExcelTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hartmut Jürgens
 */
public class JettTest {

    private static ExcelTransformer transformer = new ExcelTransformer();

    /**
     * Tests Excel 97-2003 RichTextString features.
     * <jt:if test="${condition}" then="${trueValue}" false="${falseValue}"/>
     *
     * @throws IOException
     * @throws InvalidFormatException
     */
    @Test
    public void testXls() throws IOException, InvalidFormatException {
        Map<String, Object> map = new HashMap<>();
        map.put("condition", Boolean.FALSE);
        map.put("trueValue", "is true");
        map.put("falseValue", "is false");

        transformer.transform(
                "target/test-classes/templates/RichTextStringUtilTests.xls",
                "target/test-classes/templates/Report.xls",
                map);
    }

    /**
     * Tests Excel 2007+ RichTextString features.
     * <jt:if test="${condition}" then="${trueValue}" false="${falseValue}"/>
     *
     * @throws IOException
     * @throws InvalidFormatException
     */
    @Test
    public void testXlsx() throws IOException, InvalidFormatException {
        Map<String, Object> map = new HashMap<>();
        map.put("condition", Boolean.FALSE);
        map.put("trueValue", "is true");
        map.put("falseValue", "is false");

        transformer.transform(
                "target/test-classes/templates/RichTextStringUtilTests.xlsx",
                "target/test-classes/templates/Report.xlsx",
                map);
    }

}

