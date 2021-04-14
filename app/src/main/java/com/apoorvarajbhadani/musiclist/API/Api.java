  package com.apoorvarajbhadani.musiclist.API;

import com.apoorvarajbhadani.musiclist.Models.MusicModel;
import com.apoorvarajbhadani.musiclist.Models.PostResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "https://thawing-beach-74665.herokuapp.com/";

    @GET("musics")
    Call<List<MusicModel>> getMusics();

    @FormUrlEncoded
    @POST("musics")
    Call<PostResponseModel> addMusic(
        @Field("title") String title,
        @Field("desc") String desc
    );
}
