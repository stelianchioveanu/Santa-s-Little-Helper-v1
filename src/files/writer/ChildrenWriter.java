package files.writer;

import children.Child;

import java.util.ArrayList;

public final class ChildrenWriter {
    private final ArrayList<Child> children;

    public ChildrenWriter() {
        this.children = new ArrayList<>();
    }

    public ArrayList<Child> getChildren() {
        return children;
    }
}
