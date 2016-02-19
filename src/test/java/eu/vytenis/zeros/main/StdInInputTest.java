package eu.vytenis.zeros.main;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.input.EndOfInputException;

public class StdInInputTest {
    private InputStream originalIn;
    private ByteInput input;

    @Before
    public void before() {
        originalIn = System.in;
        System.setIn(new ByteArrayInputStream(new byte[] { 10 }));
        input = new StdInInput().createInput();
    }

    @After
    public void after() {
        System.setIn(originalIn);
    }

    @Test
    public void readsAllBytesFromSystemIn() throws EndOfInputException {
        assertEquals(10, input.read());
    }

    @Test(expected = EndOfInputException.class)
    public void throwsExceptionAfterEnd() throws EndOfInputException {
        input.read();
        input.read();
    }
}
