package com.example.retrofit2.resource;

import com.example.retrofit2.model.People;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PeopleResource {

    @POST("people")
    Call<People> post(@Body People people);

    @GET("{id}")
    Call<People> get(@Path("id") Integer id);

    @GET("people")
    Call<List<People>> get();

    @PUT("{id}")
    Call<Void> put(@Path("id") Integer id, @Body People people);

    @PATCH("{id}")
    Call<Void> patch(@Path("id") Integer id, @Body People people);

    @DELETE("{id}")
    Call<Void> delete(@Path("id") Integer id);

    @OPTIONS
    Call<Void> options();

    @HEAD
    Call<Void> head();
}
