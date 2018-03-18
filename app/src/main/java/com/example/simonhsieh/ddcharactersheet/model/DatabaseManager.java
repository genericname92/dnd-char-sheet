package com.example.simonhsieh.ddcharactersheet.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by simonhsieh on 3/9/18.
 */
public final class DatabaseManager extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "characterSheets";
    private static final int DATABASE_VERSION = 1;
    private static final String CHARACTER_TABLE_NAME = "characters";
    private static final String STATS_TABLE_NAME = "stats";
    private static final String CHARACTER_LEVELS_TABLE_NAME = "character_levels";
    private static final String RACE_TABLE_NAME = "racial_traits";
    private static final String TRAITS_TABLE = "traits";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EXPERIENCE = "experience";
    private static final String COLUMN_RACE_ID = "race_id";
    private static final String COLUMN_STATS_ID = "stats_id";
    private static final String COLUMN_CHARACTER_ID = "character_id";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createRaceTable(db);
        createContactsTable(db);
        createCharacterLevelsTable(db);
        createStatsTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + CHARACTER_TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    private void createContactsTable(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + CHARACTER_TABLE_NAME + "("
                +  "ID INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_EXPERIENCE + " INTEGER"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    private void createCharacterLevelsTable(SQLiteDatabase db) {
        String CREATE_CHARACTER_LEVELS_TABLE = "CREATE TABLE " + CHARACTER_LEVELS_TABLE_NAME + "("
                + "ID INTEGER PRIMARY KEY,"
                + COLUMN_CHARACTER_ID + " INTEGER,"
                + "FOREIGN KEY (" + COLUMN_CHARACTER_ID + ") references "
                + CHARACTER_TABLE_NAME + "(" + COLUMN_CHARACTER_ID + ")"
                + " ON UPDATE SET NULL ON DELETE CASCADE,"
                + "class_name TEXT,"
                + "level INTEGER"
                + ")";

        db.execSQL(CREATE_CHARACTER_LEVELS_TABLE);
    }

    private void createStatsTable(SQLiteDatabase db) {
        String CREATE_STATS_TABLE = "CREATE TABLE " + STATS_TABLE_NAME + "("
                + "ID INTEGER PRIMARY KEY,"
                + "health_points INTEGER,"
                + "strength INTEGER,"
                + "dexterity INTEGER,"
                + "constitution INTEGER,"
                + "intelligence INTEGER,"
                + "wisdom INTEGER,"
                + "charisma INTEGER,"
                + "speed INTEGER,"
                + "armor_class INTEGER,"
                + COLUMN_CHARACTER_ID + " INTEGER,"
                + "FOREIGN KEY (" + COLUMN_CHARACTER_ID + ") references "
                + CHARACTER_TABLE_NAME + "(" + COLUMN_CHARACTER_ID + ")"
                + " ON UPDATE SET NULL ON DELETE CASCADE"
                + ")";
        db.execSQL(CREATE_STATS_TABLE);
    }

    private void createRaceTable(SQLiteDatabase db) {
        String CREATE_RACE_TABLE = "CREATE TABLE " + RACE_TABLE_NAME + "("
                + "ID INTEGER PRIMARY KEY,"
                + "race TEXT,"
                + "subrace TEXT,"
                + "trait TEXT"
                + ")";
        db.execSQL(CREATE_RACE_TABLE);
    }
}
