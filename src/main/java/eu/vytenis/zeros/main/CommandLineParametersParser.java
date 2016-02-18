package eu.vytenis.zeros.main;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class CommandLineParametersParser {
    private static final String STD_ID = "-";
    private final String[] arguments;
    List<ByteInputSource> sources = new ArrayList<ByteInputSource>();

    public CommandLineParametersParser(String[] arguments) {
        this.arguments = arguments;
    }

    public void parse() {
        for (String arg : getArgumentsForInputs())
            sources.add(createSource(arg));
    }

    private ByteInputSource createSource(String argument) {
        if (STD_ID.equals(argument))
            return new StdInInput();
        else
            return new FileInput(argument);
    }

    private List<String> getArgumentsForInputs() {
        List<String> r = new ArrayList<String>();
        r.addAll(asList(arguments));
        if (arguments.length == 0)
            r.add(STD_ID);
        return r;
    }
}
