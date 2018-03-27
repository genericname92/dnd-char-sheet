package com.example.simonhsieh.ddcharactersheet.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import com.example.simonhsieh.ddcharactersheet.database.model.Character;
import com.example.simonhsieh.ddcharactersheet.database.model.CharacterLevels;
import com.example.simonhsieh.ddcharactersheet.database.model.RacialTraits;
import com.example.simonhsieh.ddcharactersheet.database.model.Stats;

/**
 * Created by simonhsieh on 3/9/18.
 */
public final class DatabaseManager extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "characterSheets";
    private static final int DATABASE_VERSION = 1;
    private static final String RACIAL_TRAITS_TABLE_NAME = RacialTraits.getTableName();
    private static final String CHARACTER_TABLE_NAME = Character.getTableName();
    private static final String CHARACTER_LEVELS_TABLE_NAME = CharacterLevels.getTableName();
    private static final String STATS_TABLE_NAME = Stats.getTableName();

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createRaceTable(db); // no foreign keys
        createCharactersTable(db);
        createCharacterLevelsTable(db); // foreign keys characters table
        createStatsTable(db); // foreign keys character table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + RACIAL_TRAITS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CHARACTER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CHARACTER_LEVELS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + STATS_TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    private void createCharactersTable(SQLiteDatabase db) {
        String CREATE_CHARACTERS_TABLE = Character.getCreateTableString();
        db.execSQL(CREATE_CHARACTERS_TABLE);
    }

    private void createCharacterLevelsTable(SQLiteDatabase db) {
        String CREATE_CHARACTER_LEVELS_TABLE = CharacterLevels.getCreateTableString();
        db.execSQL(CREATE_CHARACTER_LEVELS_TABLE);
    }

    private void createStatsTable(SQLiteDatabase db) {
        String CREATE_STATS_TABLE = Stats.getCreateTableString();
        db.execSQL(CREATE_STATS_TABLE);
    }

    private void createRaceTable(SQLiteDatabase db) {
        String CREATE_RACE_TABLE = RacialTraits.getCreateTableString();
        db.execSQL(CREATE_RACE_TABLE);
    }
}
