package com.example.simonhsieh.ddcharactersheet.model;

/**
 * Created by simonhsieh on 3/12/18.
 */

public class Attributes {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Attributes(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public int getConstitution() {
        return this.constitution;
    }

    public int getIntelligence() {
        return this.intelligence;
    }

    public int getWisdom() {
        return this.wisdom;
    }

    public int getCharisma() {
        return this.charisma;
    }

    public void setStrength(int strength) {
        this.strength = strength;
        // TODO: propagate changes to db
    }
}
