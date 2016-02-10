package eu.vytenis.zeros.counter;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.input.EndOfInputException;

public class ZerosCounter {
	private final ByteInput input;
	private int longestChainOfZeros = 0;

	public ZerosCounter(ByteInput input) {
		this.input = input;
	}

	public int findLongestChain() {
		findResult();
		return longestChainOfZeros;
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
		int current = 0;
		while ((b = read()) >= 0) {
			if (b == 0)
				current++;
			if (current > longestChainOfZeros)
				longestChainOfZeros = current;
			if (b != 0)
				current = 0;
		}
	}

	private int read() throws EndOfInputException {
		return input.read();
	}
}
