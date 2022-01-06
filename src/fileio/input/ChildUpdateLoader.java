package fileio.input;

import enums.Category;

import java.util.ArrayList;

public class ChildUpdateLoader {
    private final Integer id;
    private final Double niceScore;
    private final ArrayList<Category> giftsPreferences;

    public ChildUpdateLoader() {
        this.id = 0;
        this.niceScore = 0.0;
        this.giftsPreferences = new ArrayList<>();
    }

    public ChildUpdateLoader(Integer id, Double niceScore,
                             ArrayList<Category> giftsPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
    }

    public Integer getId() {
        return id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }
}
