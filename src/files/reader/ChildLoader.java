package files.reader;

import enums.Cities;

public final class ChildLoader extends ChildUpdateLoader {
    private final String lastName;
    private final String firstName;
    private final Cities city;
    private final Integer age;

    public ChildLoader() {
        super();
        this.lastName = "";
        this.firstName = "";
        this.age = 0;
        this.city = Cities.BRAILA;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Cities getCity() {
        return city;
    }

    public Integer getAge() {
        return age;
    }
}
