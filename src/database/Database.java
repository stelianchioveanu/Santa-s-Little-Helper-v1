package database;

import annual.AnnualChange;
import children.Child;
import enums.Category;
import enums.Cities;
import fileio.input.ChildLoader;
import fileio.input.Input;
import fileio.writer.ChildrenWriter;
import fileio.writer.Writer;
import fileio.writer.AnnualChildrenWriter;
import gift.Gift;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database {

    private Integer numberOfYears;
    private Double santaBudget;
    private final ArrayList<Child> childrenList = new ArrayList<>();
    private final ArrayList<Gift> santaGiftsHashMap = new ArrayList<>();
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
            if (child.getAge() <= 18) {
                Child newChild = new Child(child.getId(), child.getLastName(),
                        child.getFirstName(), child.getAge(), child.getCity(),
                        child.getNiceScore(), child.getGiftsPreferences());
                this.childrenList.add(newChild);
                this.cities.add(child.getCity());
            }
        }
        this.santaGiftsHashMap.addAll(input.getInitialData().getSantaGiftsList());
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
        this.firstRound();
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

    public ArrayList<Gift> getSantaGiftsHashMap() {
        return santaGiftsHashMap;
    }

    public HashSet<Cities> getCities() {
        return cities;
    }

    public ArrayList<AnnualChange> getAnnualChangeHashMap() {
        return annualChangeHashMap;
    }

    public void sortGifts(){
        this.santaGiftsHashMap.sort((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
    }

    public void firstRound(){
        this.sortGifts();
        Double sumScores = 0.0;
        for (Child child : this.childrenList){
            if (child.getAge() < 5) {
                child.setAverageScore(10.0);
            } else {
                child.setAverageScore(child.getNiceScoreHistory().get(0));
            }
            sumScores += child.getAverageScore();
        }
        Double budgetUnit = this.santaBudget / sumScores;
        for (Child child : this.childrenList){
            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            for (Category category : child.getGiftsPreferences()){
                for (Gift gift : this.santaGiftsHashMap){
                    Double copyBudget = child.getAssignedBudget();
                    if (category.equals(gift.getCategory())){
                        if (copyBudget >= gift.getPrice()){
                        child.getReceivedGifts().add(gift);
                        copyBudget -= gift.getPrice();
                        break;}
                    }
                }
            }
        }
    }
}
