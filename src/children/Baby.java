package children;

import enums.Category;
import enums.Cities;
import files.reader.ChildLoader;
import gift.Gift;

import java.util.ArrayList;

public final class Baby extends Child {

    public Baby(final ChildLoader childLoader) {
        super(childLoader);
    }

    public Baby(final Child child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Baby";
    }
}
