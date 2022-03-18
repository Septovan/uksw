package com.septovan.pam.webservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.septovan.pam.webservice.api.ApiClient;
import com.septovan.pam.webservice.model.google.YouTubeApiResponse;
import com.septovan.pam.webservice.model.publicapi.PublicApiResponse;
import com.septovan.pam.webservice.service.PublicApiServiceInterface;
import com.septovan.pam.webservice.service.YouTubeApiServiceInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnPublicApiStartReq, btnYouTubeApiStartReq;
    private TextView txtPublicApiResult, txtYouTubeApiResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPublicApiStartReq = findViewById(R.id.btn_publicApi_startRequest);
        txtPublicApiResult = findViewById(R.id.txt_publicApi_result);

        btnPublicApiStartReq.setOnClickListener(view -> { startRequestingPublicApi(); });

        btnYouTubeApiStartReq = findViewById(R.id.btn_youTubeApi_startRequest);
        txtYouTubeApiResult = findViewById(R.id.txt_youTubeApi_result);

        btnYouTubeApiStartReq.setOnClickListener(view -> { startRequestingYouTubeApi(); });
    }

    private void startRequestingPublicApi() {
        PublicApiServiceInterface publicApiService = ApiClient.getPublicApiClient().create(PublicApiServiceInterface.class);
        Call<PublicApiResponse> getAllEntriesCall = publicApiService.getAllEntries();

        getAllEntriesCall.enqueue(new Callback<PublicApiResponse>() {
            @Override
            public void onResponse(Call<PublicApiResponse> call, Response<PublicApiResponse> response) {
                if (response.isSuccessful()) {
                    PublicApiResponse data = response.body();
                    txtPublicApiResult.setText(data.getEntries().get(0).getApiName());
                }
                else {
                    Toast.makeText(getApplicationContext(), "Request to PublicAPI server is unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PublicApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed to send a request to PublicAPI server!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startRequestingYouTubeApi() {
        String key = "AIzaSyAYEzaAnUJEXQYpR74ns5kLC2htpD0jJLo";
        String channelId = "UCLmAtLJAB9YPNO9N98rRQNg";
        String type = "video";

        YouTubeApiServiceInterface youTubeApiService = ApiClient.getYouTubeApiClient().create(YouTubeApiServiceInterface.class);
        Call<YouTubeApiResponse> getSearchResultCall = youTubeApiService.getSearchResult(key, channelId, type);
        getSearchResultCall.enqueue(new Callback<YouTubeApiResponse>() {
            @Override
            public void onResponse(Call<YouTubeApiResponse> call, Response<YouTubeApiResponse> response) {
                if (response.isSuccessful()) {
                    YouTubeApiResponse data = response.body();
                    txtYouTubeApiResult.setText(data.getItems().get(0).getId().getVideoId());
                }
                else {
                    Toast.makeText(getApplicationContext(), "YouTube API response is unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<YouTubeApiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "YouTube server is down!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}