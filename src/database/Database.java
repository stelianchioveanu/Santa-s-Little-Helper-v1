package database;

import annual.AnnualChange;
import children.Child;
import enums.Cities;
import fileio.input.Input;
import fileio.writer.Writer;
import gift.Gift;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Database {

    private Integer numberOfYears;
    private Double santaBudget;
    private final HashMap<Integer, Child> childrenHashMap = new HashMap<>();
    private final HashMap<String, Gift> santaGiftsHashMap = new HashMap<>();
    private final HashSet<Cities> cities = new HashSet<>();
    private final HashMap<Integer, AnnualChange> annualChangeHashMap = new HashMap<>();


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

    private void populateRepository(final Input input) {

    }

    private void clearRepository() {}

    public void entryPoint(final Input input, final JSONArray arrayResult,
                           final Writer fileWriter) throws IOException {
        this.populateRepository(input);
        // actions
        this.clearRepository();
    }
}
