package com.example.simonhsieh.ddcharactersheet.database.model;

/**
 * Created by simonhsieh on 3/24/18.
 */

public class CharacterLevels {
    public static String TABLE_NAME = "character_levels";
    public static String CHARACTER_TABLE_NAME = Character.getTableName();
    public static String COLUMN_ID = "id";
    public static String COLUMN_CHARACTER_ID = "character_id";
    public static String COLUMN_CLASS_NAME = "class_name";
    public static String COLUMN_CLASS_LEVEL = "level";
    public static String CREATE_CHARACTER_LEVELS_TABLE_STRING = "Create table " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_CHARACTER_ID + " INTEGER,"
            + "FOREIGN KEY (" + COLUMN_CHARACTER_ID + ") references "
            + CHARACTER_TABLE_NAME + "(" + COLUMN_CHARACTER_ID + ")"
            + " ON UPDATE SET NULL ON DELETE CASCADE,"
            + COLUMN_CLASS_NAME + " TEXT,"
            + COLUMN_CLASS_LEVEL + " INTEGER"
            + ")";

    private int id;
    private int characterId;
    private String className;
    private int level;

    public CharacterLevels(int id, int characterId, String className, int level) {
        this.id = id;
        this.characterId = characterId;
        this.className = className;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static String getCreateTableString() {
        return CREATE_CHARACTER_LEVELS_TABLE_STRING;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public String getSaveString() {
        return "INSERT OR REPLACE INTO " + TABLE_NAME + "("
                + COLUMN_ID + ", "
                + COLUMN_CHARACTER_ID + ", "
                + COLUMN_CLASS_NAME + ", "
                + COLUMN_CLASS_LEVEL + ") VALUES ("
                + this.getId() + ", "
                + this.getCharacterId() + ", "
                + this.getClassName() + ", "
                + this.getLevel() + ");";
    }
}
