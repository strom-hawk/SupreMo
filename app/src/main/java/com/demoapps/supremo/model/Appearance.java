package com.demoapps.supremo.model;

import java.util.ArrayList;

public class Appearance {
    private String gender;

    private String race;

    private ArrayList<String> height;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public ArrayList<String> getHeight() {
        return height;
    }

    public void setHeight(ArrayList<String> height) {
        this.height = height;
    }
}
