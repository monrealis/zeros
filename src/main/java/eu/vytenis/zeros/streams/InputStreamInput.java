package eu.vytenis.zeros.streams;

import java.io.IOException;
import java.io.InputStream;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.input.EndOfInputException;

public class InputStreamInput implements ByteInput {
	private final InputStream stream;

	public InputStreamInput(InputStream stream) {
		this.stream = stream;
	}

	public int read() throws EndOfInputException {
		int r = tryRead();
		if (r < 0)
			throw new EndOfInputException();
		return r;
	}

	private int tryRead() {
		try {
			return stream.read();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
