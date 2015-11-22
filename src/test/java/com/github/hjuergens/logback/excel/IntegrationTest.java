package com.github.hjuergens.logback.excel;

import com.github.hjuergens.IntegrationCategory;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.UnknownHostException;


/**
 * @author Hartmut Jürgens <hartmut_juergens@yahoo.com>
 */
@Category(IntegrationCategory.class)
public class IntegrationTest {

    private Workbook workbook;

    @Before
    public void setUp() throws UnknownHostException {
        workbook = null;
    }

    @Test
    public void test() throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        logger.debug("hello world");
        logger.debug("hello world2");
    }

    @After
    public void tearDown() throws IOException {
        //workbook.close();
    }
}
