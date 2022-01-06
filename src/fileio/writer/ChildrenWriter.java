package fileio.writer;

import children.Child;

import java.util.ArrayList;

public class ChildrenWriter {
    private ArrayList<Child> children;

    public ChildrenWriter() {
        this.children = new ArrayList<>();
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }
}
