package com.sample.projects.myrentcalculator.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sample.projects.myrentcalculator.model.UnitModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chyron-MACBOOK on 10/16/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // DATABASE VERSION
    private static final int DATABASE_VERSION = 1;
    // DATABASE NAME
    private static final String DATABASE_NAME = "db_units";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UnitModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UnitModel.TABLE_NAME);
        onCreate(db);
    }

    public long insertUnit(String unit, String rentee, String rentFee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UnitModel.COLUMN_NAME, unit);
        values.put(UnitModel.COLUMN_RENTEE, rentee);
        values.put(UnitModel.COLUMN_RENT_FEE, rentFee);

        long id = db.insert(UnitModel.TABLE_NAME, null, values);

        db.close();
        return id;
    }

    public UnitModel getUnit(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        UnitModel unitModel = null;

        Cursor cursor = db.query(UnitModel.TABLE_NAME,
                new String[]{UnitModel.COLUMN_ID,
                        UnitModel.COLUMN_NAME,
                        UnitModel.COLUMN_RENTEE,
                        UnitModel.COLUMN_RENT_FEE},
                UnitModel.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

            unitModel = new UnitModel(
                    cursor.getInt(cursor.getColumnIndex(UnitModel.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(UnitModel.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(UnitModel.COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(UnitModel.COLUMN_RENT_FEE)));
            cursor.close();
        }
        return unitModel;
    }

    public List<UnitModel> getAllUnits() {
        List<UnitModel> unitModelList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + UnitModel.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.getCount();

        if (cursor.moveToFirst()) {
            do {
                UnitModel unitModel = new UnitModel();
                unitModel.setUnitId(cursor.getInt(cursor.getColumnIndex(UnitModel.COLUMN_ID)));
                unitModel.setUnitName(cursor.getString(cursor.getColumnIndex(UnitModel.COLUMN_NAME)));
                unitModel.setRentee(cursor.getString(cursor.getColumnIndex(UnitModel.COLUMN_RENTEE)));
                unitModel.setRentFee(cursor.getString(cursor.getColumnIndex(UnitModel.COLUMN_RENT_FEE)));

                unitModelList.add(unitModel);
            } while (cursor.moveToNext());
        }
        db.close();
        return unitModelList;
    }

    public int getUnitsCount() {
        String countQuery = "SELECT  * FROM " + UnitModel.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    public int updateNote(UnitModel unitModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UnitModel.COLUMN_NAME, unitModel.getUnitName());
        values.put(UnitModel.COLUMN_RENTEE, unitModel.getRentee());
        values.put(UnitModel.COLUMN_RENT_FEE, unitModel.getRentFee());

        return db.update(UnitModel.TABLE_NAME, values, UnitModel.COLUMN_ID + " = ?",
                new String[]{String.valueOf(unitModel.getUnitId())});
    }

    public void deleteNote(UnitModel unitModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UnitModel.TABLE_NAME, UnitModel.COLUMN_ID + " = ?",
                new String[]{String.valueOf(unitModel.getUnitId())});
        db.close();
    }
}
