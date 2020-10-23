package com.example.retrofit2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.retrofit2.R;
import com.example.retrofit2.bootstrap.APIClient;
import com.example.retrofit2.model.Post;
import com.example.retrofit2.resource.PostResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostActivity extends AppCompatActivity {

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    /**
     * Método de exemplo para listar os dados de um serviço na internet utilizando o retrofit
     */

    public void listarPosts(View view){

    //Passo 06 - Criar uma função para trabalhar com o retrofit
        Retrofit retrofit = APIClient.getClient();

    //Passo 07
    //Fazer a IoC(inversão de controle) e injeção de dependência da interface (contrato) PostResource
        PostResource postResource = retrofit.create((PostResource.class));

    //Passo 08 - Fazer o método/operação preterido
        Call<List<Post>> get = postResource.get();

    //Passo 09 - Utilizar a estrutura de dados Fila(FIFO) para trabalhar com chamadas assíncronas.
        get.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //O método onResponse retorna os dados do recurso(resource consumido.
                List<Post> posts = response.body();

                //laço de repetição padrão
                for(int i=0; i<posts.size(); i++){
                    Log.i("post", String.format("%d %s", i, posts.get(i).toString()));
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //Método para tratar erro
                Toast.makeText(getApplicationContext(), "Ocorreu um erro no serviço.", Toast.LENGTH_LONG).show();

            }
        });

    }
}