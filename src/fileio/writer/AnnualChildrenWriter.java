package fileio.writer;

import java.util.ArrayList;

public class AnnualChildrenWriter {
    private ArrayList<ChildrenWriter> annualChildren;

    public AnnualChildrenWriter() {
        this.annualChildren = new ArrayList<>();
    }

    public ArrayList<ChildrenWriter> getAnnualChildren() {
        return annualChildren;
    }

    public void setAnnualChildren(ArrayList<ChildrenWriter> children) {
        this.annualChildren = children;
    }
}
