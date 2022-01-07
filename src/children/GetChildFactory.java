package children;

import common.Constants;
import files.reader.ChildLoader;

public final class GetChildFactory {

    public Child getChildByChildLoader(final Integer age, final ChildLoader child) {
        Child newChild = null;
        if (age < Constants.KID) {
            newChild = new Baby(child);
        } else if (age < Constants.TEEN) {
            newChild = new Kid(child);
        } else if (age <= Constants.YOUNG_ADULT) {
            newChild = new Teen(child);
        }
        return newChild;
    }

    public Child getChildByChild(final Integer age, final Child child) {
        Child newChild = null;
        if (age < Constants.KID) {
            newChild = new Baby(child);
        } else if (age < Constants.TEEN) {
            newChild = new Kid(child);
        } else if (age <= Constants.YOUNG_ADULT) {
            newChild = new Teen(child);
        }
        return newChild;
    }
}
