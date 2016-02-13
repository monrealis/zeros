package eu.vytenis.zeros.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.streams.InputStreamInput;

public class CommandLineParamsParser {
    private final String[] args;
    List<ByteInputSource> sources = new ArrayList<ByteInputSource>();

    public CommandLineParamsParser(String[] args) {
        this.args = args;
    }

    public void parse() {
        for (final String arg : args)
            sources.add(new ByteInputSource() {
                public ByteInput createInput() {
                    try {
                        return new InputStreamInput(new FileInputStream(arg));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
    }
}
