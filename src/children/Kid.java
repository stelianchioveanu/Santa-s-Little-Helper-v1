package children;

import enums.Category;
import enums.Cities;
import files.reader.ChildLoader;
import gift.Gift;

import java.util.ArrayList;

public final class Kid extends Child {

    public Kid(final ChildLoader childLoader) {
        super(childLoader);
    }

    public Kid(final Child child) {
        super((child));
    }

    @Override
    public String getChildType() {
        return "Kid";
    }
}
