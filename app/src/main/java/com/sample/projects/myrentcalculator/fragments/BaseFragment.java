package com.sample.projects.myrentcalculator.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.projects.myrentcalculator.R;
import com.sample.projects.myrentcalculator.data.DataProvider;
import com.sample.projects.myrentcalculator.databinding.FragmentUnitBinding;
import com.sample.projects.myrentcalculator.eventhandler.FragmentsEventHandler;
import com.sample.projects.myrentcalculator.model.UnitModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/22/18.
 */

public class BaseFragment extends Fragment {

    //region VARIABLES
    private FragmentUnitBinding binding;
    private String pageTitle;
    protected DataProvider dataProvider;
    protected List<UnitModel> unitModelList;
    private int page;
    //endregion

    //region VIEW
    protected RecyclerView mRecyclerView;
    //endregion

    //region SETUP
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutResourceId(), container, false);
        View view = binding.getRoot();

        FragmentsEventHandler eh = new FragmentsEventHandler(getActivity());
        binding.setEh(eh);

        dataProvider = new DataProvider(getActivity());
        unitModelList = new ArrayList<>();

        setupViewBinding();
        setupRecyclerViewAdapter();

        return view;
    }

    private void setupViewBinding() {
        mRecyclerView = binding.mRecyclerView;
    }

    public void setupRecyclerViewAdapter() {
    }
    //endregion

    //region GETTERS AND SETTERS
    private int getLayoutResourceId() {
        return R.layout.fragment_unit;
    }
    //endregion
}
