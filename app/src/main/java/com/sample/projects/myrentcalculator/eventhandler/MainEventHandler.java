package com.sample.projects.myrentcalculator.eventhandler;

import android.content.Context;

import com.sample.projects.myrentcalculator.interfaces.MainInterface;
import com.sample.projects.myrentcalculator.activities.MainActivity;

/**
 * Created by Chyron-MACBOOK on 10/5/18.
 */

public class MainEventHandler {

    private Context context;
    private MainActivity mainActivity;
    private MainInterface.OnClick onClickInterface;

    public MainEventHandler(Context context,
                            MainActivity mainActivity,
                            MainInterface.OnClick onClickInterface) {
        this.context = context;
        this.mainActivity = mainActivity;
        this.onClickInterface = onClickInterface;

    }

    public void ehOnClickHamburgerButton() {
        onClickInterface.onClickHamburgerButton();
    }

    public void ehOnClickAddUnitButton() {
        onClickInterface.onClickAddUnitButton();
    }

    public void ehOnClickRemoveUnitButton() {
        onClickInterface.onClickRemoveUnitButton();
    }
}
