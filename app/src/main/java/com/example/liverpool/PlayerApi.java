package com.example.liverpool;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PlayerApi {
    @GET("/catacretu/Project/master/{json}")
    Call<ArrayList<PlayerEntity>> getPersons(@Path("json") String jsonToFetch);
}
