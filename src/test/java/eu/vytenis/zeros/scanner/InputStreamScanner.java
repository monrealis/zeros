package eu.vytenis.zeros.scanner;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamScanner {
	private final File file;

	public InputStreamScanner(File file) {
		this.file = file;
	}

	public void run() {
		try {
			tryRun();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void tryRun() throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		while (is.read() >= 0)
			;
		is.close();
	}

}
