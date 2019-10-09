package com.piotrdevelop.unityconverter;

import android.provider.BaseColumns;

public class Contract {

    private Contract() {
    }

    public static final class FavoriteEntry implements BaseColumns {
        public static final String TABLE_NAME = "favoriteList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }

}
