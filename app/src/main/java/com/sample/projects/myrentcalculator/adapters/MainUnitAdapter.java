package com.sample.projects.myrentcalculator.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.projects.myrentcalculator.R;
import com.sample.projects.myrentcalculator.databinding.LayoutMainUnitRowBinding;
import com.sample.projects.myrentcalculator.model.UnitModel;

import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/9/18.
 */

public class MainUnitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //region VARIABLES
    private List<UnitModel> unitModelList;
    //endregion

    //region SETUP
    public MainUnitAdapter(List<UnitModel> unitModelList) {
        this.unitModelList = unitModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewHolder itemViewHolder = new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getLayoutResourceId(), parent, false));
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        UnitModel unitModel = unitModelList.get(position);

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.getBinding().mTVUnitName.setText(unitModel.getUnitName());
        itemViewHolder.getBinding().mTVRentFee.setText(String.valueOf(unitModel.getRentFee()));
        itemViewHolder.getBinding().mLayoutRowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MAIN_UNIT_ADAPTER", "position: "+position);
            }
        });
    }
    //endregion

    //region VIEW HOLDER
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private LayoutMainUnitRowBinding binding;

        public ItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public LayoutMainUnitRowBinding getBinding() {
            return binding;
        }
    }
    //endregion

    //region GETTERS AND SETTERS
    private int getLayoutResourceId() {
        return R.layout.layout_main_unit_row;
    }

    @Override
    public int getItemCount() {
        return unitModelList == null ? 0 : unitModelList.size();
    }
    //endregion
}
