package com.sample.projects.myrentcalculator.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.projects.myrentcalculator.R;
import com.sample.projects.myrentcalculator.adapters.MainUnitAdapter;
import com.sample.projects.myrentcalculator.data.DataProvider;
import com.sample.projects.myrentcalculator.databinding.FragmentUnitBinding;
import com.sample.projects.myrentcalculator.model.UnitModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/9/18.
 */

public class DipologFragment extends Fragment {

    //region VARIABLES
    private FragmentUnitBinding binding;
    private String pageTitle;
    private DataProvider dataProvider;
    private List<UnitModel> unitModelList;
    private static final int LOCATION = 1; // Dipolog
    private int page;
    //endregion

    //region VIEW
    private RecyclerView mRecyclerView;
    //endregion

    //region SETUP
    public static ManilaFragment newInstance(String pageTitle,
                                             int page) {
        ManilaFragment fragment = new ManilaFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutResourceId(), container, false);
        View view = binding.getRoot();

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
    //endregion

    //region GETTERS AND SETTERS
    private int getLayoutResourceId() {
        return R.layout.fragment_unit;
    }
    //endregion
}
