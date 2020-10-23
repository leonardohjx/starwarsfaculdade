package com.example.retrofit2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit2.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void exibir(View view) {

        //Pegar a opção da tela passada por parâmetro
        int opcao = view.getId();

        Intent intent = null;

        switch(opcao){
            case R.id.btnAbrirPosts:

                intent = new Intent(this,PostActivity.class);
                startActivity(intent);

                break;

            case R.id.btnAbrirStarWars:

                intent = new Intent(this,PeopleActivity.class);
                startActivity(intent);
                break;


        }
    }
}