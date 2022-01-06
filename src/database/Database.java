package database;

import annual.AnnualChange;
import children.Child;
import enums.Category;
import enums.Cities;
import fileio.input.ChildLoader;
import fileio.input.ChildUpdateLoader;
import fileio.input.Input;
import fileio.writer.ChildrenWriter;
import fileio.writer.Writer;
import fileio.writer.AnnualChildrenWriter;
import gift.Gift;

import java.io.IOException;
import java.util.*;

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
                Child newChild = new Child(child);
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
        AnnualChildrenWriter writerOutput = new AnnualChildrenWriter();
        ChildrenWriter childrenWriter = new ChildrenWriter();

        this.populateRepository(input);
        this.firstRound();
        for (Child child : this.childrenList){
            childrenWriter.getChildren().add(new Child(child.getId(),
                    child.getLastName(), child.getFirstName(), child.getCity(), child.getAge(),
                    child.getGiftsPreferences(), child.getAverageScore(), child.getNiceScoreHistory(),
                    child.getAssignedBudget(), child.getReceivedGifts()));
        }
        writerOutput.getAnnualChildren().add(childrenWriter);
        for (int i = 0; i < this.numberOfYears; i++){
            this.nextRound(i);
            childrenWriter = new ChildrenWriter();
            for (Child child : this.childrenList){
                childrenWriter.getChildren().add(new Child(child.getId(),
                        child.getLastName(), child.getFirstName(), child.getCity(), child.getAge(),
                        child.getGiftsPreferences(), child.getAverageScore(), child.getNiceScoreHistory(),
                        child.getAssignedBudget(), child.getReceivedGifts()));
            }
            writerOutput.getAnnualChildren().add(childrenWriter);
        }

        fileWriter.writeFile(writerOutput);
        this.clearRepository();
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void sortGifts(){
        this.santaGiftsHashMap.sort(Comparator.comparingDouble(Gift::getPrice));
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
            Double copyBudget = child.getAssignedBudget();
            for (Category category : child.getGiftsPreferences()){
                for (Gift gift : this.santaGiftsHashMap){
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

    public void nextRound(Integer year){
        for (Child child : this.childrenList){
            child.setAge(child.getAge() + 1);
            child.getReceivedGifts().clear();
        }
        for (int i = 0; i < this.childrenList.size(); i++){
            if (this.childrenList.get(i).getAge() > 18){
                this.childrenList.remove(i);
                i--;
            }
        }
        AnnualChange currentAnnualChange = this.annualChangeHashMap.get(year);
        this.santaBudget = currentAnnualChange.getNewSantaBudget();
        for (ChildLoader child : currentAnnualChange.getNewChildren()){
            if (child.getAge() <= 18) {
                Child newChild = new Child(child);
                this.childrenList.add(newChild);
                this.cities.add(child.getCity());
            }
        }
        this.santaGiftsHashMap.addAll(currentAnnualChange.getNewGifts());
        for (ChildUpdateLoader childUpdateLoader : currentAnnualChange.getChildrenUpdates()){
            for (Child child : this.childrenList){
                if (Objects.equals(child.getId(), childUpdateLoader.getId())) {
                    if (childUpdateLoader.getNiceScore() != null){
                        child.getNiceScoreHistory().add(childUpdateLoader.getNiceScore());
                    }
                    Collections.reverse(childUpdateLoader.getGiftsPreferences());
                    for (Category category : childUpdateLoader.getGiftsPreferences()){
                        child.getGiftsPreferences().remove(category);
                        child.getGiftsPreferences().add(0, category);
                    }

                    break;
                }
            }
        }

        this.sortGifts();
        Double sumScores = 0.0;
        for (Child child : this.childrenList){
            if (child.getAge() < 5) {
                child.setAverageScore(10.0);
            } else if (child.getAge() >= 5 && child.getAge() < 12){
                Double niceScoreSum = child.getNiceScoreHistory().stream().reduce(0.0, Double::sum);
                child.setAverageScore(niceScoreSum / child.getNiceScoreHistory().size());
            } else {
                Double niceScoreSum = 0.0;
                for (int i = 0; i < child.getNiceScoreHistory().size(); i++){
                    niceScoreSum += child.getNiceScoreHistory().get(i) * (i + 1);
                }
                child.setAverageScore(niceScoreSum / ((child.getNiceScoreHistory().size() * (child.getNiceScoreHistory().size() + 1))/2));
            }
            sumScores += child.getAverageScore();
        }
        Double budgetUnit = this.santaBudget / sumScores;
        for (Child child : this.childrenList){
            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            Double copyBudget = child.getAssignedBudget();
            for (Category category : child.getGiftsPreferences()){
                for (Gift gift : this.santaGiftsHashMap){
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
