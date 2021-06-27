package com.example.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostService {

    String API_ROUTE = "/posts";

    @GET(API_ROUTE)
    Call< List<PostTitle> > getPost();

    @POST(API_ROUTE)
    @FormUrlEncoded
    Call<Post> savePost(@Field("name") String name);
}
