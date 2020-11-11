package com.demoapps.supremo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Connections {
    @SerializedName("relatives")
    @Expose
    private String relatives;

    @SerializedName("group-affiliation")
    @Expose
    private String groupAffiliation;

    public String getRelatives() {
        return relatives;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }

    public String getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(String groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }
}
