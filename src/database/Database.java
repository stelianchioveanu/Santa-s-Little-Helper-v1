package database;

import fileio.input.Input;
import fileio.writer.Writer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Database {

    private static Database instance = null;

    private Database() {
    }

    /**
     * If the Repository instance is null, create a new one
     *
     * @return Instance of Repository class
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private void populateRepository(final Input input) {}

    private void clearRepository() {}

    public void entryPoint(final Input input, final JSONArray arrayResult,
                           final Writer fileWriter) throws IOException {
        this.populateRepository(input);
        // actions
        this.clearRepository();
    }
}
