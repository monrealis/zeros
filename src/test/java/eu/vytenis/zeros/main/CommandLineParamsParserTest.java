package eu.vytenis.zeros.main;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CommandLineParamsParserTest {
    private List<String> params = new ArrayList<String>();
    private String sources;

    @Test
    public void withEmptyParams_oneSource() {
        parse();
        assertEquals("I", sources);
    }

    @Test
    public void withOneParam_oneSource() {
        params.add("file1.txt");
        parse();
        assertEquals("F", sources);
    }

    @Test
    public void withTwoParams_twoSources() {
        params.add("file1.txt");
        params.add("file2.txt");
        parse();
        assertEquals("FF", sources);
    }

    private void parse() {
        CommandLineParamsParser p = new CommandLineParamsParser(
                params.toArray(new String[] {}));
        p.parse();
        collectSources(p);
    }

    private void collectSources(CommandLineParamsParser p) {
        sources = "";
        for (ByteInputSource o : p.sources)
            sources += abbreviate(o);
    }

    private String abbreviate(ByteInputSource source) {
        if (source instanceof FileInput)
            return "F";
        if (source instanceof StdInInput)
            return "I";
        throw new IllegalArgumentException();
    }
}
