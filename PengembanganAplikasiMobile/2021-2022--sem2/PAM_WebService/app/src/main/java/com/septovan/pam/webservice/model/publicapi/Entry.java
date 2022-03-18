package com.septovan.pam.webservice.model.publicapi;

import com.google.gson.annotations.SerializedName;

public class Entry {

    @SerializedName("API")
    private String apiName;

    public Entry(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

}
