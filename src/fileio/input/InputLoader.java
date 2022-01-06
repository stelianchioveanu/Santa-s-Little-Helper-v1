package fileio.input;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class InputLoader {
    /**
     * The path to the input file
     */
    private final String inputPath;

    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    public Input readData(){
        Input input = new Input();

        try {
            input = new ObjectMapper().readerFor(Input.class).readValue(new File(this.inputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
