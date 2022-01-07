package annual;

import files.reader.ChildUpdateLoader;
import files.reader.ChildLoader;
import gift.Gift;

import java.util.ArrayList;

public final class AnnualChange {
    private final Double newSantaBudget;
    private final ArrayList<Gift> newGifts;
    private final ArrayList<ChildLoader> newChildren;
    private final ArrayList<ChildUpdateLoader> childrenUpdates;

    public AnnualChange() {
        this.newSantaBudget = 0.0;
        this.newGifts = new ArrayList<>();
        this.newChildren = new ArrayList<>();
        this.childrenUpdates = new ArrayList<>();
    }

    public AnnualChange(final Double newSantaBudget, final ArrayList<Gift> newGifts,
                        final ArrayList<ChildLoader> newChildren,
                        final ArrayList<ChildUpdateLoader> childrenUpdates) {
        this.newSantaBudget = newSantaBudget;
        this.newGifts = newGifts;
        this.newChildren = newChildren;
        this.childrenUpdates = childrenUpdates;
    }

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    public ArrayList<ChildLoader> getNewChildren() {
        return newChildren;
    }

    public ArrayList<ChildUpdateLoader> getChildrenUpdates() {
        return childrenUpdates;
    }
}
