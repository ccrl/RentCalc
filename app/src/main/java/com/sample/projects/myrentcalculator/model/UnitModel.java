package com.sample.projects.myrentcalculator.model;

public class UnitModel {

    public static final String TABLE_NAME = "table_units";
    public static final String COLUMN_ID = "unit_id";
    public static final String COLUMN_NAME = "unit_name";
    public static final String COLUMN_RENTEE = "unit_rentee";
    public static final String COLUMN_RENT_FEE = "unit_rent_fee";
    public static final String COLUMN_LOCATION = "unit_location";

    private static final String MANILA = "MANILA";
    private static final String DIPOLOG = "DIPOLOG";

    private int unitId;
    private String unitName;
    private String rentee;
    private String rentFee;
    private String rentOriginalFee;
    private String rentStartDate;
    private int location;
    private String strLocation;
    private double rentFeeDbl;
    private boolean isOccupied;

    public UnitModel() {}

    public UnitModel(int unitId, String unitName, String rentee, String rentFee) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.rentee = rentee;
        this.rentFee = rentFee;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_RENTEE + " TEXT,"
                    + COLUMN_RENT_FEE + " TEXT,"
                    + COLUMN_LOCATION + " TEXT"
                    + ")";

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getRentee() {
        return rentee;
    }

    public void setRentee(String rentee) {
        this.rentee = rentee;
    }

    public String getRentFee() {
        return rentFee;
    }

    public void setRentFee(String rentFee) {
        this.rentFee = rentFee;
    }

    public String getRentOriginalFee() {
        return rentOriginalFee;
    }

    public void setRentOriginalFee(String rentOriginalFee) {
        this.rentOriginalFee = rentOriginalFee;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getStrLocation() {
        if (getLocation() == 0) {
            strLocation = MANILA;
        } else {
            strLocation = DIPOLOG;
        }
        return strLocation;
    }

    public void setStrLocation(String strLocation) {
        this.strLocation = strLocation;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }


}
