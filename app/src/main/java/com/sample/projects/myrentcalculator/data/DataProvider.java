package com.sample.projects.myrentcalculator.data;

import android.content.Context;

import com.sample.projects.myrentcalculator.R;
import com.sample.projects.myrentcalculator.model.UnitModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/4/18.
 * Location Legend:
 *  0 - Manila
 *  1 - Dipolog
 */

public class DataProvider {

    //region VARIABLES
    private Context context;
    private List<Integer> intList;
    private List<String> stringList;
    private List<UnitModel> unitModelList;

    private UnitModel unitModel;
    //endregion

    public DataProvider() {}

    public DataProvider(Context context) {
        this.context = context;
    }

    public List<UnitModel> getUnitList() {
        unitModelList = new ArrayList<>();

        unitModel = new UnitModel();
        unitModel.setUnitName("Unit A Manila");
        unitModel.setRentee("temp rentee");
        unitModel.setRentFee("2000");
        unitModel.setLocation(0);
        unitModelList.add(unitModel);

        unitModel = new UnitModel();
        unitModel.setUnitName("Unit A Dipolog");
        unitModel.setRentee("temp rentee");
        unitModel.setRentFee("3000");
        unitModel.setLocation(1);
        unitModelList.add(unitModel);

        unitModel = new UnitModel();
        unitModel.setUnitName("Unit B Dipolog");
        unitModel.setRentee("temp rentee");
        unitModel.setRentFee("10000");
        unitModel.setLocation(1);
        unitModelList.add(unitModel);

        unitModel = new UnitModel();
        unitModel.setUnitName("Unit B Manila");
        unitModel.setRentee("temp rentee");
        unitModel.setRentFee("90000");
        unitModel.setLocation(0);
        unitModelList.add(unitModel);

        return unitModelList;
    }
}
