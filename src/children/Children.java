package children;

import enums.Cities;

import java.util.ArrayList;

public class Children {
    Integer id;
    String lastName;
    String firstName;
    Integer age;
    Cities city;
    Double niceScore;
    ArrayList<String> giftsPreference;

    public Children(Integer id, String lastName, String firstName, Integer age, Cities city, Double niceScore, ArrayList<String> giftsPreference) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreference = giftsPreference;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<String> getGiftsPreference() {
        return giftsPreference;
    }

    public void setGiftsPreference(ArrayList<String> giftsPreference) {
        this.giftsPreference = giftsPreference;
    }
}
