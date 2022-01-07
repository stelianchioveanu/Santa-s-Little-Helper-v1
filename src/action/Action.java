package action;

import annual.AnnualChange;
import children.*;
import common.Constants;
import database.Database;
import enums.Category;
import files.reader.ChildLoader;
import files.reader.ChildUpdateLoader;
import gift.Gift;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public final class Action {

    public void addNewChildren(final Database database,
                               final List<ChildLoader> childLoaderArrayList) {
        for (ChildLoader child : childLoaderArrayList) {
            GetChildFactory childFactory = new GetChildFactory();

            if (childFactory.getChildByChildLoader(child.getAge(), child) != null) {
                database.getChildrenList().add(childFactory.getChildByChildLoader(child.getAge(), child));
            }
        }
    }

    public void distributionGifts(final Database database, final Double budgetUnit) {
        for (Child child : database.getChildrenList()) {

            child.setAssignedBudget(child.getAverageScore() * budgetUnit);
            Double copyBudget = child.getAssignedBudget();

            for (Category category : child.getGiftsPreferences()) {

                for (Gift gift : database.getSantaGiftsList()) {

                    if (category.equals(gift.getCategory())) {

                        if (copyBudget >= gift.getPrice()) {
                            child.getReceivedGifts().add(gift);
                            copyBudget -= gift.getPrice();
                            break;
                        }
                    }
                }
            }
        }
    }

    public void increaseAge(final Database database) {
        for (int i = 0; i < database.getChildrenList().size(); i++) {
            database.getChildrenList().get(i).setAge(
                    database.getChildrenList().get(i).getAge() + 1);
            database.getChildrenList().get(i).getReceivedGifts().clear();

            String childType = database.getChildrenList().get(i).getChildType();
            Integer age = database.getChildrenList().get(i).getAge();
            Child newChild;
            GetChildFactory getChildFactory = new GetChildFactory();

            if (childType.equals(Constants.BABY_STRING) && age == Constants.KID) {
                newChild = getChildFactory.getChildByChild(age, database.getChildrenList().get(i));
                database.getChildrenList().remove(i);
                database.getChildrenList().add(i, newChild);
            } else if (childType.equals(Constants.KID_STRING) && age == Constants.TEEN) {
                newChild = getChildFactory.getChildByChild(age, database.getChildrenList().get(i));
                database.getChildrenList().remove(i);
                database.getChildrenList().add(i, newChild);
            } else if (childType.equals(Constants.TEEN_STRING) && age > Constants.YOUNG_ADULT) {
                database.getChildrenList().remove(i);
                i--;
            }
        }
    }

    public Double budgetUnit(final Database database) {
        Double sumScores = 0.0;

        for (Child child : database.getChildrenList()) {

            if (child.getChildType().equals(Constants.BABY_STRING)) {
                child.setAverageScore(Constants.BABY_SCORE);

            } else if (child.getChildType().equals(Constants.KID_STRING)) {
                Double niceScoreSum = child.getNiceScoreHistory().stream().
                        reduce(0.0, Double::sum);
                child.setAverageScore(niceScoreSum / child.getNiceScoreHistory().size());

            } else {
                double niceScoreSum = 0.0;
                for (int i = 0; i < child.getNiceScoreHistory().size(); i++) {
                    niceScoreSum += child.getNiceScoreHistory().get(i) * (i + 1);
                }
                child.setAverageScore(niceScoreSum
                        / ((child.getNiceScoreHistory().size()
                        * (child.getNiceScoreHistory().size() + 1)) / 2));

            }
            sumScores += child.getAverageScore();
        }

        return database.getSantaBudget() / sumScores;
    }

    public void sortGifts(final Database database) {
        database.getSantaGiftsList().sort(Comparator.comparingDouble(Gift::getPrice));
    }

    public void updateChild(final Database database, final AnnualChange currentAnnualChange) {
        for (ChildUpdateLoader childUpdateLoader : currentAnnualChange.getChildrenUpdates()) {

            for (Child child : database.getChildrenList()) {

                if (Objects.equals(child.getId(), childUpdateLoader.getId())) {
                    if (childUpdateLoader.getNiceScore() != null) {
                        child.getNiceScoreHistory().add(childUpdateLoader.getNiceScore());
                    }

                    Collections.reverse(childUpdateLoader.getGiftsPreferences());

                    for (Category category : childUpdateLoader.getGiftsPreferences()) {
                        child.getGiftsPreferences().remove(category);
                        child.getGiftsPreferences().add(0, category);
                    }

                    break;
                }
            }
        }
    }
}
