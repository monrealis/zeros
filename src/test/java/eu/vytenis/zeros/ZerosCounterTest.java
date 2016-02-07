package eu.vytenis.zeros;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import eu.vytenis.zeros.streams.InputStreamInput;

public class ZerosCounterTest {
	private byte[] bytes = new byte[] {};

	@Test
	public void returnsZeroForEmptyInput() {
		assertEquals(0, countMax());
	}

	@Test
	public void countsAllZeros() {
		bytes = new byte[10];
		assertEquals(bytes.length, countMax());
	}

	@Test
	public void countsOnlyZeros() {
		bytes = new byte[10];
		bytes[0] = 1;
		assertEquals(9, countMax());
	}

	private int countMax() {
		ZerosCounter counter = new ZerosCounter(createInput());
		return counter.findLongestChain();
	}

	private InputStreamInput createInput() {
		return new InputStreamInput(new ByteArrayInputStream(bytes));
	}
}
