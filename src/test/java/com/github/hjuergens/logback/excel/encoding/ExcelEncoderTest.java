package com.github.hjuergens.logback.excel.encoding;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

public class ExcelEncoderTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile = folder.newFile("myfile.txt");
        File createdFolder = folder.newFolder("subfolder");
    }

    @Test
    public void testInit() throws Exception {

    }

    @Test
    public void testDoEncode() throws Exception {

    }

    @Test
    public void testClose() throws Exception {

    }

    @Test
    public void testSetFileName() throws Exception {

    }

    @Test
    public void testSetSheetName() throws Exception {

    }

    @Test
    public void testSetPassword() throws Exception {

    }
}
