package com.sample.projects.myrentcalculator.model;

/**
 * Created by Chyron-MACBOOK on 10/5/18.
 */

public class CategoryModel {

    private String dateOfConsumption;
    private String previousReading;
    private String presentReading;
    private String consumption;
    private String due;
    private String unit;
    private boolean isElectricity;

    public CategoryModel() {}

    public String getDateOfConsumption() {
        return dateOfConsumption;
    }

    public void setDateOfConsumption(String dateOfConsumption) {
        this.dateOfConsumption = dateOfConsumption;
    }

    public String getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(String previousReading) {
        this.previousReading = previousReading;
    }

    public String getPresentReading() {
        return presentReading;
    }

    public void setPresentReading(String presentReading) {
        this.presentReading = presentReading;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isElectricity() {
        return isElectricity;
    }

    public void setElectricity(boolean electricity) {
        isElectricity = electricity;
    }
}
