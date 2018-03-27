package com.example.simonhsieh.ddcharactersheet.database.model;

/**
 * Created by simonhsieh on 3/25/18.
 */

public class RacialTraits {
    public static String TABLE_NAME = "racial_traits";
    public static String COLUMN_ID = "id";
    public static String COLUMN_RACE = "race";
    public static String COLUMN_SUBRACE = "subrace";
    public static String COLUMN_TRAIT = "trait";
    public static String CREATE_RACIAL_TRAITS_TABLE_STRING = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_RACE + " TEXT,"
            + COLUMN_SUBRACE + " TEXT,"
            + COLUMN_TRAIT + " TEXT"
            + ")";

    private int id;
    private String race;
    private String subrace;
    private String trait;

    public static String getCreateTableString() {
        return CREATE_RACIAL_TRAITS_TABLE_STRING;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public RacialTraits(int id, String race, String subrace, String trait) {
        this.id = id;
        this.race = race;
        this.subrace = subrace;
        this.trait = trait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSubrace() {
        return subrace;
    }

    public void setSubrace(String subrace) {
        this.subrace = subrace;
    }

    public String getTrait() {
        return trait;
    }

    public void setTrait(String trait) {
        this.trait = trait;
    }

    public String getSaveString() {
        String saveString = "INSERT OR REPLACE INTO " + TABLE_NAME + "("
                + COLUMN_ID + ", "
                + COLUMN_RACE + ", "
                + COLUMN_SUBRACE + ", "
                + COLUMN_TRAIT + ")"
                + " VALUES("
                + this.getId() + ", "
                + this.getRace() + ", "
                + this.getSubrace() + ", "
                + this.getTrait() + ");";

        return saveString;
    }

}
