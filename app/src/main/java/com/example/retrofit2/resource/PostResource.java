package com.example.retrofit2.resource;

import com.example.retrofit2.model.Post;

import java.util.List;

import lombok.Getter;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Precisamos mapear os métodos disponíveis para esta interface que será nosso contrato de serviço.
 * POST, PUT, PATCH, DELETE, OPTIONS e GET
 */

public interface PostResource {

    @POST("posts")
    Call<Post> post(@Body Post post);

    @GET("{id}")
    Call<Post> get(@Path("id") Integer id);

    @GET("posts")
    Call<List<Post>> get();

    @PUT("{id}")
    Call<Void> put(@Path("id") Integer id, @Body Post post);

    @PATCH("{id}")
    Call<Void> patch(@Path("id") Integer id, @Body Post post);

    @DELETE("{id}")
    Call<Void> delete(@Path("id") Integer id);

    @OPTIONS
    Call<Void> options();

    @HEAD
    Call<Void> head();

}
