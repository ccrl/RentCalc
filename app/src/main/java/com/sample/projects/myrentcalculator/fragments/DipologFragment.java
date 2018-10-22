package com.sample.projects.myrentcalculator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.sample.projects.myrentcalculator.adapters.MainUnitAdapter;
import com.sample.projects.myrentcalculator.data.DatabaseHelper;
import com.sample.projects.myrentcalculator.model.UnitModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/9/18.
 */

public class DipologFragment extends BaseFragment {

    protected static int LOCATION = 1; // Dipolog

    //region SETUP
    public static DipologFragment newInstance(String pageTitle,
                                             int page) {
        DipologFragment fragment = new DipologFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setupRecyclerViewAdapter() {
        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());
        if (dbHelper.getAllUnits().size() > 0) {
            MainUnitAdapter adapter = new MainUnitAdapter(dbHelper.getAllUnits());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mRecyclerView.setAdapter(adapter);
        } else {
            List<String> contentList = new ArrayList<>();
            if (dataProvider != null) {
                for (int i = 0; dataProvider.getUnitList().size() > i; i++) {
                    UnitModel unitModel = dataProvider.getUnitList().get(i);
                    if (unitModel.getLocation() == LOCATION) {
                        unitModelList.add(unitModel);
                    }
                }
                MainUnitAdapter adapter = new MainUnitAdapter(unitModelList);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecyclerView.setAdapter(adapter);
            }
        }
    }
    //endregion
}
