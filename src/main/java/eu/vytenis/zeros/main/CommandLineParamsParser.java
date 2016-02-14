package eu.vytenis.zeros.main;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParamsParser {
    private final String[] arguments;
    List<ByteInputSource> sources = new ArrayList<ByteInputSource>();

    public CommandLineParamsParser(String[] arguments) {
        this.arguments = arguments;
    }

    public void parse() {
        for (final String arg : getArgumentsForInputs())
            sources.add(new FileInput(arg));
    }

    private List<String> getArgumentsForInputs() {
        List<String> r = new ArrayList<String>();
        r.addAll(asList(arguments));
        if (arguments.length == 0)
            r.add("-");
        return r;
    }
}
