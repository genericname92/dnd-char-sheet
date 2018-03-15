package com.example.simonhsieh.ddcharactersheet.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by simonhsieh on 3/9/18.
 */
public final class CharacterDatabaseManager extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "characterSheets";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "characters";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_RACE_ID = "race_id";
    private static final String RACE_TABLE_NAME = "races";
//    private static final String COLUMN_STATS_ID = "stats_id";
//    private static final String STATS_TABLE_NAME = "stats";

    public CharacterDatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO: Figure out how I want to store spells for a character.. join table with a generic spells list probably?
        String CREATE_CONTACTS_TABLE = "CREATE TABLE" + TABLE_NAME + "("
                +  "ID INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT,"
                + COLUMN_RACE_ID + " INTEGER,"
                + "FOREIGN KEY (" + COLUMN_RACE_ID + ") references "
                + RACE_TABLE_NAME + "(" + COLUMN_RACE_ID + ")"
                // TODO: This should be reversed: FK on stats table pointing to character id
//                + COLUMN_STATS_ID + " INTEGER,"
//                + "FOREIGN KEY (" + COLUMN_STATS_ID + ") references "
//                + STATS_TABLE_NAME + "(" + COLUMN_STATS_ID + ")"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
