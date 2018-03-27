package com.example.simonhsieh.ddcharactersheet.database.model;

/**
 * Created by simonhsieh on 3/19/18.
 */

public class Character {
    public static final String TABLE_NAME = "characters";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EXPERIENCE = "experience";
    public static final String COLUMN_RACE = "race";
    public static final String COLUMN_SUBRACE = "subrace";
    public static final String CREATE_CHARACTERS_TABLE_STRING = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_EXPERIENCE + " INTEGER,"
            + COLUMN_RACE + " TEXT,"
            + COLUMN_SUBRACE + " TEXT,"
            + ")";

    private int id;
    private String name;
    private int experience;
    private String race;
    private String subrace;

    public Character(int id, String name, int experience, String race, String subrace) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.race = race;
        this.subrace = subrace;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public String getRace() {
        return this.race;
    }

    public String getSubrace() {
        return this.subrace;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int xp) {
        this.experience = xp;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setSubrace(String subrace) {
        this.subrace = subrace;
    }

    @org.jetbrains.annotations.Contract(pure = true)
    public static String getCreateTableString() {
        return CREATE_CHARACTERS_TABLE_STRING;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public String generateSaveString() {
        // TODO: GROSS INSERT OR REPLACE BUT IDK HOW TO UPSERT SO BLAH
        String saveString = "INSERT OR REPLACE INTO " + TABLE_NAME +"("
                + COLUMN_ID + ", "
                + COLUMN_NAME + ", "
                + COLUMN_EXPERIENCE + ", "
                + COLUMN_RACE + ", "
                + COLUMN_SUBRACE
                + ") VALUES("
                + this.getId() + ", "
                + this.getName() + ", "
                + this.getExperience() + ", "
                + this.getRace() + ", "
                + this.getSubrace() + ");";

        return saveString;
    }
}
