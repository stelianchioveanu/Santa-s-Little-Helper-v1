package children;

import enums.Category;
import enums.Cities;
import gift.Gift;

import java.util.ArrayList;

public class Child{
    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private final Integer age;
    private final ArrayList<Category> giftsPreferences;
    private final Double averageScore;
    private final ArrayList<Double> niceScoreHistory;
    private final Double assignedBudget;
    private final ArrayList<Gift> receivedGifts;

    public Child(Integer id, String lastName, String firstName, Integer age, Cities city, Double niceScore, ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.giftsPreferences = new ArrayList<>();
        this.giftsPreferences.addAll(giftsPreferences);
        this.averageScore = 0.0;
        this.niceScoreHistory = new ArrayList<>();
        this.niceScoreHistory.add(niceScore);
        this.assignedBudget = 0.0;
        this.receivedGifts = new ArrayList<>();
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
}
