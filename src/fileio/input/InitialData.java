package fileio.input;

import children.Child;
import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public class InitialData {
    private final List<ChildLoader> children;
    private final List<Gift> santaGiftsList;

    public InitialData() {
        this.children = new ArrayList<>();
        this.santaGiftsList = new ArrayList<>();
    }

    public InitialData(List<ChildLoader> children, List<Gift> santaGiftsList) {
        this.children = children;
        this.santaGiftsList = santaGiftsList;
    }

    public List<ChildLoader> getChildren() {
        return children;
    }

    public List<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }
}
