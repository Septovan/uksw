package com.septovan.pam.webservice.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String PUBLIC_API_BASE_URL = "https://api.publicapis.org/";
    private static Retrofit publicApiClient;

    private static final String YOUTUBE_API_BASE_URL = "https://www.googleapis.com/youtube/v3/";
    private static Retrofit youTubeApiClient;

    private ApiClient() {}

    public static Retrofit getPublicApiClient() {
        if (publicApiClient == null) {
            publicApiClient = new Retrofit.Builder()
                    .baseUrl(PUBLIC_API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return publicApiClient;
    }

    public static Retrofit getYouTubeApiClient() {
        if (youTubeApiClient == null) {
            youTubeApiClient = new Retrofit.Builder()
                    .baseUrl(YOUTUBE_API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return youTubeApiClient;
    }

}
