package com.github.hjuergens.logback.excel;

import ch.qos.logback.classic.LoggerContext;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExcelAppenderTest {

    ExcelAppender appender = new ExcelAppender();

    @Test
    public void addWarn() throws Exception {
        appender.setFile("test.xls");
        appender.start();
        appender.addWarn("warning");
    }

    @Test
    public void testAppend() throws Exception {
        appender.setAppend(true);
        assertTrue(appender.isAppend());
        appender.setAppend(false);
        assertFalse(appender.isAppend());
    }

    @Test
    public void testSheetName() throws Exception {
        appender.setContext(new LoggerContext());
        appender.setSheetName(":\\*");
        assertEquals(1, appender.getStatusManager().getCopyOfStatusList().size());
    }

}
