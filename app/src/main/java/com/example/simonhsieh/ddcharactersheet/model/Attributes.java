package com.example.simonhsieh.ddcharactersheet.model;

/**
 * Created by simonhsieh on 3/12/18.
 */

public class Attributes {
    private int _strength;
    private int _dexterity;
    private int _constitution;
    private int _intelligence;
    private int _wisdom;
    private int _charisma;

    public Attributes(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this._strength = strength;
        this._dexterity = dexterity;
        this._constitution = constitution;
        this._intelligence = intelligence;
        this._wisdom = wisdom;
        this._charisma = charisma;
    }

    public int getStrength() {
        return this._strength;
    }

    public int getDexterity() {
        return this._dexterity;
    }

    public int getConstitution() {
        return this._constitution;
    }

    public int getIntelligence() {
        return this._intelligence;
    }

    public int getWisdom() {
        return this._wisdom;
    }

    public int getCharisma() {
        return this._charisma;
    }

    public void setStrength(int strength) {
        this._strength = strength;
        // TODO: propagate changes to db
    }
}
