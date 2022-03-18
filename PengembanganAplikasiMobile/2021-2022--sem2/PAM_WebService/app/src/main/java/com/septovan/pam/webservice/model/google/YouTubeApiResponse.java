package com.septovan.pam.webservice.model.google;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class YouTubeApiResponse {

    @SerializedName("items")
    private ArrayList<Item> items;

    public YouTubeApiResponse(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
