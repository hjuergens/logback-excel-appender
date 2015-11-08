package net.sf.hajuergens;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExcelAppenderTest {

    @Test
    public void testStart() throws Exception {
        // mock creation
        List mockedList = mock(List.class);

        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testStop() throws Exception {

    }

    @Test
    public void testAppend() throws Exception {

    }
}