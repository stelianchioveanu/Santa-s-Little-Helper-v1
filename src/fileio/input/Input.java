package fileio.input;

import annual.AnnualChange;
import children.Child;
import gift.Gift;

import java.util.ArrayList;
import java.util.List;

public class Input {
    private final Integer numberOfYears;
    private final Double santaBudget;
    private final InitialData initialData;
    private final List<AnnualChange> annualChanges;

    public Input() {
        this.numberOfYears = 0;
        this.santaBudget = 0.0;
        this.initialData = new InitialData();
        this.annualChanges = new ArrayList<>();
    }

    public Input(Integer numberOfYears, Double santaBudget,
                 InitialData initialData,
                 List<AnnualChange> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.initialData = initialData;
        this.annualChanges = annualChanges;
    }

    public Integer getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public List<AnnualChange> getAnnualChanges() {
        return annualChanges;
    }
}
