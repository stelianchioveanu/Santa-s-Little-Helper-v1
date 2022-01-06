package fileio.input;


import annual.AnnualChange;
import children.Child;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constants;
import enums.Cities;
import gift.Gift;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            ObjectMapper objectMapper = new ObjectMapper();
            input = objectMapper.readerFor(Input.class).readValue(new File(this.inputPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
