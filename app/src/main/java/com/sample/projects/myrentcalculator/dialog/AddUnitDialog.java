package com.sample.projects.myrentcalculator.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.sample.projects.myrentcalculator.R;
import com.sample.projects.myrentcalculator.data.DatabaseHelper;
import com.sample.projects.myrentcalculator.databinding.LayoutDialogAddUnitBinding;
import com.sample.projects.myrentcalculator.eventhandler.AddUnitEventHandler;
import com.sample.projects.myrentcalculator.fragments.DipologFragment;
import com.sample.projects.myrentcalculator.fragments.ManilaFragment;
import com.sample.projects.myrentcalculator.main.MainActivity;
import com.sample.projects.myrentcalculator.model.UnitModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.sample.projects.myrentcalculator.main.MainActivity.VALUE_FRAGMENT_DIPOLOG;
import static com.sample.projects.myrentcalculator.main.MainActivity.VALUE_FRAGMENT_MANILA;

/**
 * Created by Chyron-MACBOOK on 10/9/18.
 */

public class AddUnitDialog extends DialogFragment {

    //region VARIABLES
    private LayoutDialogAddUnitBinding binding;
    private String pageTitle;
    private String keyFragment;
    private AddUnitEventHandler eh;
    private Fragment fragment;

    private static final String KEY_UNIT_NAME = "unit_name";
    private static final String KEY_UNIT_RENTEE = "unit_rentee";
    private static final String KEY_UNIT_RENT_FEE = "unit_rent_fee";
    //endregion

    //region VIEWS
    private TextInputLayout mUnitNameLabel;
    private TextInputEditText mETUnitNameValue;
    private TextInputLayout mRenteeLabel;
    private TextInputEditText mETRenteeValue;
    private TextInputLayout mRentFeeLabel;
    private TextInputEditText mETRentFeeValue;
    private TextView mTVLocationLabel;
    //endregion

    //region SETUP
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(getLayoutResourceId(), null);
        binding = DataBindingUtil.bind(view);
        eh = new AddUnitEventHandler(getActivity(), binding);

        setupViewBinding();
        setupBundle();

        return setupDialog(view).show();
    }

    private AlertDialog.Builder setupDialog(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.mBaseTheme_Dialog_AddUnit)
                .setView(view)
                .setCancelable(false)
                .setTitle("Add Unit in " + pageTitle)
                .setNegativeButton(R.string.label_button_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton(R.string.label_button_unit_add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fragment = new Fragment();

                        onClickAddUnit();
                    }
                });
        return builder;
    }

    private void setupViewBinding() {
        mUnitNameLabel = binding.mUnitNameLabel;
        mETUnitNameValue = binding.mETUnitNameValue;
        mRenteeLabel = binding.mRenteeLabel;
        mETRenteeValue = binding.mETRenteeValue;
        mRentFeeLabel = binding.mRentFeeLabel;
        mETRentFeeValue = binding.mETRentFeeValue;
        mTVLocationLabel = binding.mTVLocationLabel;

        mUnitNameLabel.setHint(getString(R.string.label_unit_unit_name));
        mRenteeLabel.setHint(getString(R.string.label_unit_rentee));
        mRentFeeLabel.setHint(getString(R.string.label_unit_rent_fee));
        mTVLocationLabel.setText(R.string.label_unit_location);
    }

    private void setupBundle() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String getPageTitle = bundle.getString(MainActivity.KEY_TITLE);
            if (getPageTitle == MainActivity.VALUE_MANILA) {
                pageTitle = getString(R.string.label_manila);
                keyFragment = VALUE_FRAGMENT_MANILA;
            } else if (getPageTitle == MainActivity.VALUE_DIPOLOG) {
                pageTitle = getString(R.string.label_dipolog);
                keyFragment = VALUE_FRAGMENT_DIPOLOG;
            }
        }
    }
    //endregion

    //region ONCLICK
    public void onClickAddUnit() {
        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());
        dbHelper.insertUnit(mETUnitNameValue.getText().toString(),
                mETRenteeValue.getText().toString(),
                mETRentFeeValue.getText().toString());

        dbHelper.getUnitsCount();

        //todo: the fragments can change by using only one fragment..
        if (keyFragment == VALUE_FRAGMENT_MANILA) {
            ManilaFragment fragment = new ManilaFragment();
            fragment.setupRecyclerViewAdapter();
        } else if (keyFragment == VALUE_FRAGMENT_DIPOLOG) {
            DipologFragment fragment = new DipologFragment();
            fragment.setupRecyclerViewAdapter();
        }
    }
    //endregion

    //region JSON
    private String createJSON() {

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put(KEY_UNIT_NAME, mETUnitNameValue.getText().toString());
            jsonObject.put(KEY_UNIT_RENTEE, mETRenteeValue.getText().toString());
            jsonObject.put(KEY_UNIT_RENT_FEE, mETRentFeeValue.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    //endregion

    //region GETTERS AND SETTERS
    private int getLayoutResourceId() {
        return R.layout.layout_dialog_add_unit;
    }
    //endregion
}
