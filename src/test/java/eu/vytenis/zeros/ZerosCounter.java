package eu.vytenis.zeros;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.input.EndOfInputException;

public class ZerosCounter {
	private final ByteInput input;
	private int result = 0;

	public ZerosCounter(ByteInput input) {
		this.input = input;
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
			else
				result = 0;
	}

	private int read() throws EndOfInputException {
		return input.read();
	}
}
