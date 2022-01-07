package children;

import enums.Category;
import enums.Cities;
import files.reader.ChildLoader;
import gift.Gift;

import java.util.ArrayList;

public abstract class Child {
    protected final Integer id;
    protected final String lastName;
    protected final String firstName;
    protected final Cities city;
    protected Integer age;
    protected final ArrayList<Category> giftsPreferences;
    protected Double averageScore;
    protected final ArrayList<Double> niceScoreHistory;
    protected Double assignedBudget;
    protected final ArrayList<Gift> receivedGifts;

    public Child(final ChildLoader childLoader) {
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

    public Child(final Child child) {
        this.id = child.id;
        this.lastName = child.lastName;
        this.firstName = child.firstName;
        this.city = child.city;
        this.age = child.age;
        this.giftsPreferences = child.giftsPreferences;
        this.averageScore = child.averageScore;
        this.niceScoreHistory = child.niceScoreHistory;
        this.assignedBudget = child.assignedBudget;
        this.receivedGifts = child.receivedGifts;
    }

    public ArrayList<Category> getGiftsPreferences(){
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

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public abstract String getChildType();
}
