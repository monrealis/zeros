package eu.vytenis.zeros.main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.input.EndOfInputException;

public class FileInputTest {
    private ByteInput input;

    @Before
    public void before() {
        input = new FileInput("target/test-classes/FileInputTest.txt")
                .createInput();
    }

    @Test
    public void readsAllBytesFromFile() throws EndOfInputException {
        assertEquals('x', input.read());
    }

    @Test(expected = EndOfInputException.class)
    public void throwsExceptionAfterEnd() throws EndOfInputException {
        input.read();
        input.read();
    }
}
