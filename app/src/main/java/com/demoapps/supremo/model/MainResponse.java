package com.demoapps.supremo.model;

/*
This class is used for response
*/

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainResponse {

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("error")
    @Expose
    private String errorMessage;

    @SerializedName("results")
    @Expose
    private ArrayList<Results> results;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }
}
