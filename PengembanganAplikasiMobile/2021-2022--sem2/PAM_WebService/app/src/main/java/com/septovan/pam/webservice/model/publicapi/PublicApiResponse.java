package com.septovan.pam.webservice.model.publicapi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PublicApiResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("entries")
    private ArrayList<Entry> entries;

    public PublicApiResponse(int count, ArrayList<Entry> entries) {
        this.count = count;
        this.entries = entries;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Entry> entries) {
        this.entries = entries;
    }

}
