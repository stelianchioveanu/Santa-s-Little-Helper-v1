package annual;

import children.Child;
import children.ChildUpdate;
import fileio.input.ChildLoader;
import gift.Gift;

import java.util.ArrayList;

public class AnnualChange {
    private final Double newSantaBudget;
    private final ArrayList<Gift> newGifts;
    private final ArrayList<ChildLoader> newChildren;
    private final ArrayList<ChildUpdate> childrenUpdates;

    public AnnualChange() {
        this.newSantaBudget = 0.0;
        this.newGifts = new ArrayList<>();
        this.newChildren = new ArrayList<>();
        this.childrenUpdates = new ArrayList<>();
    }

    public AnnualChange(Double newSantaBudget, ArrayList<Gift> newGifts,
                        ArrayList<ChildLoader> newChildren,
                        ArrayList<ChildUpdate> childrenUpdates) {
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

    public ArrayList<ChildUpdate> getChildrenUpdates() {
        return childrenUpdates;
    }
}
