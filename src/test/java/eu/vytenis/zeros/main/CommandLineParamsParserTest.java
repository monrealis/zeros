package eu.vytenis.zeros.main;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CommandLineParamsParserTest {
    private List<String> params = new ArrayList<String>();

    @Test
    public void withEmptyParams_zeroSources() {
        assertEquals(emptyList(), create().sources);
    }

    @Test
    public void withOneParam_oneSource() {
        params.add("file1.txt");
        assertEquals(1, create().sources.size());
    }

    @Test
    public void withTwoParams_twoSources() {
        params.add("file1.txt");
        params.add("file2.txt");
        assertEquals(2, create().sources.size());
    }

    private CommandLineParamsParser create() {
        CommandLineParamsParser p = new CommandLineParamsParser(params.toArray(new String[] {}));
        p.parse();
        return p;
    }
}
