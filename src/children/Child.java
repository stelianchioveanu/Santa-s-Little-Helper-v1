package children;

import enums.Category;
import enums.Cities;
import fileio.input.ChildLoader;
import gift.Gift;

import java.util.ArrayList;

public class Child{
    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private Integer age;
    private final ArrayList<Category> giftsPreferences;
    private Double averageScore;
    private final ArrayList<Double> niceScoreHistory;
    private Double assignedBudget;
    private final ArrayList<Gift> receivedGifts;

    public Child(ChildLoader childLoader) {
        this.id = childLoader.getId();
        this.lastName = childLoader.getLastName();
        this.firstName = childLoader.getFirstName();
        this.age = childLoader.getAge();
        this.city = childLoader.getCity();
        this.giftsPreferences = new ArrayList<>();
        this.giftsPreferences.addAll(childLoader.getGiftsPreferences());
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(childLoader.getNiceScore());
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
    }

    public Child(Integer id, String lastName,
                 String firstName, Cities city,
                 Integer age, ArrayList<Category> giftsPreferences,
                 Double averageScore, ArrayList<Double> niceScoreHistory,
                 Double assignedBudget, ArrayList<Gift> receivedGifts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = new ArrayList<>();
        this.giftsPreferences.addAll(giftsPreferences);
        this.averageScore = averageScore;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.addAll(niceScoreHistory);
        this.assignedBudget = assignedBudget;
        this.receivedGifts = new ArrayList<>();
        this.receivedGifts.addAll(receivedGifts);
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public void setAssignedBudget(Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
