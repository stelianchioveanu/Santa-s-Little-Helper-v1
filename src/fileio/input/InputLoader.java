package fileio.input;

import fileio.input.Input;
import org.json.simple.parser.JSONParser;

public class InputLoader {
    /**
     * The path to the input file
     */
    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public String getInputPath() {
        return inputPath;
    }

    public Input readData(){
        JSONParser jsonParser = new JSONParser();
        return null;
    }
}
