package eu.vytenis.zeros;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

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

	private int countMax() {
		ZerosCounter counter = new ZerosCounter(new ByteArrayInputStream(bytes));
		return counter.findLongestChain();
	}
}
