package com.sample.projects.myrentcalculator.model;

public class RenteeModel {

    private String name;
    private String rentAmount;
    private String rentStartDate;
    private String renteeUnit;
    private String isUnitOccupied;

    public RenteeModel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(String rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getRenteeUnit() {
        return renteeUnit;
    }

    public void setRenteeUnit(String renteeUnit) {
        this.renteeUnit = renteeUnit;
    }

    public String getIsUnitOccupied() {
        return isUnitOccupied;
    }

    public void setIsUnitOccupied(String isUnitOccupied) {
        this.isUnitOccupied = isUnitOccupied;
    }
}
