package children;

import enums.Category;
import enums.Cities;
import files.reader.ChildLoader;
import gift.Gift;

import java.util.ArrayList;

public final class Teen extends Child {

    public Teen(final ChildLoader childLoader) {
        super(childLoader);
    }

    public Teen(final Child child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Teen";
    }
}
