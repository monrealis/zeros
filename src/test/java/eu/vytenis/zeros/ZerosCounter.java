package eu.vytenis.zeros;

import java.io.IOException;
import java.io.InputStream;

public class ZerosCounter {
	private final InputStream input;

	public ZerosCounter(InputStream input) {
		this.input = input;
	}

	public int findLongestChain() {
		try {
			int r = 0;
			int b;
			while ((b = input.read()) >= 0)
				if (b == 0)
					r++;
			return r;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
