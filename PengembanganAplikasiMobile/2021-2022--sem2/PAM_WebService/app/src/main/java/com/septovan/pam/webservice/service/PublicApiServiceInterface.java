package com.septovan.pam.webservice.service;

import com.septovan.pam.webservice.model.publicapi.PublicApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PublicApiServiceInterface {

    @GET("entries")
    Call<PublicApiResponse> getAllEntries();

    @GET("random")
    Call<PublicApiResponse> getEntryRandomly();
    
}
