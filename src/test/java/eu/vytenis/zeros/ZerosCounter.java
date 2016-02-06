package eu.vytenis.zeros;

import java.io.InputStream;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.input.EndOfInputException;
import eu.vytenis.zeros.streams.InputStreamInput;

public class ZerosCounter {
	private final ByteInput input;
	private int result = 0;

	public ZerosCounter(InputStream input) {
		this.input = new InputStreamInput(input);
	}

	public int findLongestChain() {
		findResult();
		return result;
	}

	private void findResult() {
		try {
			tryFindResult();
		} catch (EndOfInputException e) {
			return;
		}
	}

	private void tryFindResult() throws EndOfInputException {
		int b;
		while ((b = read()) >= 0)
			if (b == 0)
				result++;
	}

	private int read() throws EndOfInputException {
		return input.read();
	}
}
