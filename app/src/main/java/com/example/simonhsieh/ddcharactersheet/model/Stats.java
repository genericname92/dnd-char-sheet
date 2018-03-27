package com.example.simonhsieh.ddcharactersheet.model;

import com.example.simonhsieh.ddcharactersheet.model.Attributes;

/**
 * Created by simonhsieh on 3/12/18.
 */

public class Stats {
    Attributes attributes;
    int healthPoints;
    int speed;

    public Stats (Attributes attributes, int healthPoints, int speed) {
        this.attributes = attributes;
        this.healthPoints = healthPoints;
        this.speed = speed;
    };
}
