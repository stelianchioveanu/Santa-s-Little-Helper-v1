package fileio.input;

import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public class InitialDataLoader {
    private final List<ChildLoader> children;
    private final List<Gift> santaGiftsList;

    public InitialDataLoader() {
        this.children = new ArrayList<>();
        this.santaGiftsList = new ArrayList<>();
    }

    public InitialDataLoader(List<ChildLoader> children, List<Gift> santaGiftsList) {
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
