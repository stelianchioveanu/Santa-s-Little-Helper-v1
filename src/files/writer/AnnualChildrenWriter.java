package files.writer;

import java.util.ArrayList;

public final class AnnualChildrenWriter {
    private final ArrayList<ChildrenWriter> annualChildren;

    public AnnualChildrenWriter() {
        this.annualChildren = new ArrayList<>();
    }

    public ArrayList<ChildrenWriter> getAnnualChildren() {
        return annualChildren;
    }
}
