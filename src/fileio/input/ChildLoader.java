package fileio.input;

import enums.Category;

import java.util.ArrayList;

public class ChildLoader {
    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final String city;
    private final Integer age;
    private final ArrayList<Category> giftsPreferences;
    private final Double niceScore;

    public ChildLoader() {
        this.id = 0;
        this.lastName = "";
        this.firstName = "";
        this.city = "";
        this.age = 0;
        this.giftsPreferences = new ArrayList<>();
        this.niceScore = 0.0;
    }

    public ChildLoader(Integer id, String lastName, String firstName, String city, Integer age, ArrayList<Category> giftsPreferences, Double nicescore) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.age = age;
        this.giftsPreferences = giftsPreferences;
        this.niceScore = nicescore;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public Double getNiceScore() {
        return niceScore;
    }
}
