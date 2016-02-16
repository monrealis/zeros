package eu.vytenis.zeros.main;

import eu.vytenis.zeros.input.ByteInput;
import eu.vytenis.zeros.streams.InputStreamInput;

public class StdInInput implements ByteInputSource {
    public ByteInput createInput() {
        return new InputStreamInput(System.in);
    }
}
