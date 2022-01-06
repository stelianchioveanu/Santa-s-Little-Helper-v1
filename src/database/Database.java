package database;

import annual.AnnualChange;
import children.Child;
import enums.Cities;
import fileio.input.ChildLoader;
import fileio.input.Input;
import fileio.writer.ChildrenWriter;
import fileio.writer.Writer;
import fileio.writer.AnnualChildrenWriter;
import gift.Gift;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database {

    private Integer numberOfYears;
    private Double santaBudget;
    private final ArrayList<Child> childrenList = new ArrayList<>();
    private final HashMap<String, Gift> santaGiftsHashMap = new HashMap<>();
    private final HashSet<Cities> cities = new HashSet<>();
    private final ArrayList<AnnualChange> annualChangeHashMap = new ArrayList<>();

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
        this.numberOfYears = input.getNumberOfYears();
        this.santaBudget = input.getSantaBudget();
        for (ChildLoader child : input.getInitialData().getChildren()){
            Child newChild = new Child(child.getId(), child.getLastName(),
                    child.getFirstName(), child.getAge(), child.getCity(),
                    child.getNiceScore(), child.getGiftsPreferences());
            this.childrenList.add(newChild);
            this.cities.add(child.getCity());
        }
        for (Gift gift : input.getInitialData().getSantaGiftsList()){
            this.santaGiftsHashMap.put(gift.getProductName(), gift);
        }
        this.annualChangeHashMap.addAll(input.getAnnualChanges());
    }

    private void clearRepository() {
        this.numberOfYears = 0;
        this.santaBudget = 0.0;
        this.cities.clear();
        this.childrenList.clear();
        this.santaGiftsHashMap.clear();
        this.annualChangeHashMap.clear();
    }

    public void entryPoint(final Input input, final Writer fileWriter) throws IOException {
        this.populateRepository(input);
        AnnualChildrenWriter writerOutput = new AnnualChildrenWriter();
        ChildrenWriter childrenWriter = new ChildrenWriter();
        childrenWriter.getChildren().addAll(this.childrenList);
        writerOutput.getAnnualChildren().add(childrenWriter);
        fileWriter.writeFile(writerOutput);
        this.clearRepository();
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public ArrayList<Child> getChildrenList() {
        return childrenList;
    }

    public HashMap<String, Gift> getSantaGiftsHashMap() {
        return santaGiftsHashMap;
    }

    public HashSet<Cities> getCities() {
        return cities;
    }

    public ArrayList<AnnualChange> getAnnualChangeHashMap() {
        return annualChangeHashMap;
    }
}
