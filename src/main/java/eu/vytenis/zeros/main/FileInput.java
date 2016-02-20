package eu.vytenis.zeros.main;

import java.io.FileInputStream;
import java.io.IOException;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.streams.InputStreamInput;

public class FileInput implements ByteInputSource {
    private final String fileName;

    public FileInput(String fileName) {
        this.fileName = fileName;
    }

    public ByteInput createInput() {
        try {
            return new InputStreamInput(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}