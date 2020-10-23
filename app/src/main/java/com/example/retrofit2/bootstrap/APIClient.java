package com.example.retrofit2.bootstrap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Passo 3: Criar classe para mapear ENDPOINT e configurar classe para fazer o PARSER que é converter o JSON para objeto.
 */
public class APIClient {

    //No retrofit você precisa colocar o / (slash).
    public static final String ENDPOINT = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
