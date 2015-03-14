package com.example.kitten.discountcalculator.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by kitten on 3/14/15.
 */
public class DbContract {
    public static final String CONTENT_AUTHORITY = "com.example.kitten.discountcalculator.app";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PERCENTAGE = "percentage";

    public static final class PercentageEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PERCENTAGE).build();
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PERCENTAGE;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PERCENTAGE;


        public static final String TABLE_NAME = "percentage";
        public static final String COLUMN_PERC = "perc";
        public static final String COLUMN_COLOR = "color";
    }
}
