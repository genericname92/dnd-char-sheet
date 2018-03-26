package com.example.simonhsieh.ddcharactersheet.database.model;

public class Stats {
    public static final String TABLE_NAME = "stats";
    public static final String CHARACTER_TABLE_NAME = Character.getTableName();
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_HP = "hp";
    public static final String COLUMN_SPEED = "speed";
    public static final String COLUMN_ARMOR_CLASS = "armor_class";
    public static final String COLUMN_STRENGTH = "strength";
    public static final String COLUMN_DEXTERITY = "dexterity";
    public static final String COLUMN_CONSTITUTION = "constitution";
    public static final String COLUMN_INTELLIGENCE = "intelligence";
    public static final String COLUMN_WISDOM = "wisdom";
    public static final String COLUMN_CHARISMA = "charisma";
    public static final String COLUMN_CHARACTER_ID = "character_id";

    public static final String CREATE_STATS_TABLE_STRING = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_HP + " INTEGER,"
            + COLUMN_SPEED + " INTEGER,"
            + COLUMN_ARMOR_CLASS + " INTEGER,"
            + COLUMN_STRENGTH + " INTEGER,"
            + COLUMN_DEXTERITY + " INTEGER,"
            + COLUMN_CONSTITUTION + " INTEGER,"
            + COLUMN_INTELLIGENCE + " INTEGER,"
            + COLUMN_WISDOM + " INTEGER,"
            + COLUMN_CHARISMA + " INTEGER,"
            + COLUMN_CHARACTER_ID + " INTEGER,"
            + "FOREIGN KEY (" + COLUMN_CHARACTER_ID + ") references "
            + CHARACTER_TABLE_NAME + "(" + COLUMN_CHARACTER_ID + ")"
            + " ON UPDATE SET NULL ON DELETE CASCADE"
            + ")";

    private int id;
    private int hp;
    private int speed;
    private int armorClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int characterId;

    public Stats(int id, int hp, int speed, int armorClass, int[] attributes, int characterId) {
        this.id = id;
        this.hp = hp;
        this.speed = speed;
        this.armorClass = armorClass;
        this.strength = attributes[0];
        this.dexterity = attributes[1];
        this.constitution = attributes[2];
        this.intelligence = attributes[3];
        this.wisdom = attributes[4];
        this.charisma = attributes[5];
        this.characterId = characterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public static String getCreateTableString() {
        return CREATE_STATS_TABLE_STRING;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public String generateSaveString() {
        // TODO: GROSS INSERT OR REPLACE BUT IDK HOW TO UPSERT SO BLAH
        String saveString = "INSERT OR REPLACE INTO " + TABLE_NAME + "("
                + COLUMN_ID + ", "
                + COLUMN_HP + ", "
                + COLUMN_SPEED + ", "
                + COLUMN_ARMOR_CLASS + ", "
                + COLUMN_STRENGTH + ", "
                + COLUMN_DEXTERITY + ", "
                + COLUMN_CONSTITUTION + ", "
                + COLUMN_INTELLIGENCE + ", "
                + COLUMN_WISDOM + ", "
                + COLUMN_CHARISMA
                + ") VALUES("
                + this.getId() + ", "
                + this.getHp() + ", "
                + this.getSpeed() + ", "
                + this.getArmorClass() + ", "
                + this.getStrength() + ", "
                + this.getDexterity() + ", "
                + this.getConstitution() + ", "
                + this.getIntelligence() + ", "
                + this.getWisdom() + ", "
                + this.getCharisma() + ");";

        return saveString;
    }
}
