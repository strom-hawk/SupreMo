package com.demoapps.supremo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {
    @SerializedName("name")
    @Expose
    private String superHeroName;

    @SerializedName("connections")
    @Expose
    private Connections connections;

    @SerializedName("image")
    @Expose
    private SuperHeroImage superHeroImage;

    @SerializedName("appearance")
    @Expose
    private Appearance appearance;

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public Connections getConnections() {
        return connections;
    }

    public void setConnections(Connections connections) {
        this.connections = connections;
    }

    public SuperHeroImage getSuperHeroImage() {
        return superHeroImage;
    }

    public void setSuperHeroImage(SuperHeroImage superHeroImage) {
        this.superHeroImage = superHeroImage;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }
}
