package com.demoapps.supremo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Appearance {
    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("race")
    @Expose
    private String race;

    @SerializedName("eye-color")
    @Expose
    private String eyeColor;

    @SerializedName("hair-color")
    @Expose
    private String hairColor;

    @SerializedName("height")
    @Expose
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

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}
