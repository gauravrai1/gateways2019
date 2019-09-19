package com.example.kaksha.API.Services;

import com.example.kaksha.API.Models.Request.TestRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    //Auth Module
    @GET("query={testData}")
    Call<TestRequest> requestAnxietyData(@Path(value = "testData",
            encoded = true) String testData);

}
