package com.demoapps.supremo.model;

import com.google.gson.annotations.SerializedName;

public class Biography {

    @SerializedName("full-name")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
