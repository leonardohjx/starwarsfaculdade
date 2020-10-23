package com.example.retrofit2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit2.R;
import com.example.retrofit2.bootstrap.APIClienteSW;
import com.example.retrofit2.model.People;
import com.example.retrofit2.model.Post;
import com.example.retrofit2.resource.PeopleResource;
import com.example.retrofit2.resource.PostResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PeopleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
    }

    public void listarPeople(View view){

        Retrofit retrofit = APIClienteSW.getClient();

        PeopleResource peopleResource = retrofit.create((PeopleResource.class));

        Call<List<People>> get = peopleResource.get();

        get.enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                List<People> people = response.body();

                for(int i=0; i<people.size(); i++){
                    Log.i("people", String.format("%d %s", i, people.get(i).toString()));
                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro no serviço", Toast.LENGTH_LONG).show();
            }
        });
    }
}