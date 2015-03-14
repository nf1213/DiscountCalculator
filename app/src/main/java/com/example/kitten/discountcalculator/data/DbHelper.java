package com.example.kitten.discountcalculator.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kitten on 3/14/15.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "percentage.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_PERCENTAGE_TABLE = "CREATE TABLE" +
                DbContract.PercentageEntry.TABLE_NAME + " (" + DbContract.PercentageEntry._ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + DbContract.PercentageEntry.COLUMN_PERC +
                " INTEGER NOT NULL, " +  DbContract.PercentageEntry.COLUMN_COLOR +
                " TEXT NOT NULL, " + "UNIQUE (" + DbContract.PercentageEntry.COLUMN_PERC + " ));";

        sqLiteDatabase.execSQL(SQL_CREATE_PERCENTAGE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DbContract.PercentageEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
