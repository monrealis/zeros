package eu.vytenis.zeros;

import java.io.IOException;
import java.io.InputStream;

public class ZerosCounter {
	private final InputStream input;
	private int result = 0;

	public ZerosCounter(InputStream input) {
		this.input = input;
	}

	public int findLongestChain() {
		int b;
		while ((b = read()) >= 0)
			if (b == 0)
				result++;
		return result;
	}

	private int read() {
		try {
			return input.read();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
