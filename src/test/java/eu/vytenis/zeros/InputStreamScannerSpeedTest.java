package eu.vytenis.zeros;

import static org.junit.Assume.assumeTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class InputStreamScannerSpeedTest {
	private File file = new File("target/100mb");

	@Before
	public void before() {
		assumeTrue(file.exists());
	}

	@Test
	public void run() {
		new InputStreamScanner(file).run();
	}

}
