package com.apoorvarajbhadani.musiclist;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apoorvarajbhadani.musiclist.API.RetrofitClient;
import com.apoorvarajbhadani.musiclist.Models.PostResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddSongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);
        EditText titleEditText, descEditText;
        titleEditText = (EditText) findViewById(R.id.new_song_title_edittext);
        descEditText = (EditText) findViewById(R.id.new_song_desc_edittext);
        Button addNewSongBtn = (Button) findViewById(R.id.new_song_button);
        addNewSongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "" + titleEditText.getText();
                String desc = "" + descEditText.getText();
                Call<PostResponseModel> call = RetrofitClient.getInstance().getApi().addMusic(title, desc);
                call.enqueue(new Callback<PostResponseModel>() {
                    @Override
                    public void onResponse(Call<PostResponseModel> call, Response<PostResponseModel> response) {

                        Toast.makeText(getApplicationContext(),"Saved Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostResponseModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}