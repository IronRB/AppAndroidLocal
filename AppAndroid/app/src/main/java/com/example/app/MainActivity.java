package com.example.app;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<>();
    private TextView mResponseTv;

    public void save(View view){
        Log.i("info","boton presionado");
        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();
        System.out.println(name);
        sendPost(name);
        getPosts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendPost(String name) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.62:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call call = postService.savePost(name);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    Log.i("onResponse: ", response.body().getname());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }

        });
    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<List<PostTitle>> call = postService.getPost();

        call.enqueue(new Callback<List<PostTitle>>() {
            @Override
            public void onResponse(Call<List<PostTitle>> call, Response<List<PostTitle>> response) {
                for(PostTitle postTitle : response.body()) {
                    names.add(postTitle.gettitle());
                }
                System.out.println(names);
                //arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PostTitle>> call, Throwable t) {
            }
        });
    }
}