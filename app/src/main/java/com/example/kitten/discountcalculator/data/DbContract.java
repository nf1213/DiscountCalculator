package com.example.kitten.discountcalculator.data;

import android.provider.BaseColumns;

/**
 * Created by kitten on 3/14/15.
 */
public class DbContract {
    public static final class PercentageEntry implements BaseColumns {
        public static final String TABLE_NAME = "percentage";
        public static final String COLUMN_PERC = "perc";
        public static final String COLUMN_COLOR = "color";
    }
}
