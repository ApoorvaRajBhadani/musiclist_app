package com.apoorvarajbhadani.musiclist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.apoorvarajbhadani.musiclist.API.RetrofitClient;
import com.apoorvarajbhadani.musiclist.Adapter.MusicAdapter;
import com.apoorvarajbhadani.musiclist.Models.MusicModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Call<List<MusicModel>> call =   RetrofitClient.getInstance().getApi().getMusics();
        call.enqueue(new Callback<List<MusicModel>>() {
            @Override
            public void onResponse(Call<List<MusicModel>> call, Response<List<MusicModel>> response) {
                List<MusicModel> musicList = response.body();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new MusicAdapter(getApplicationContext(),musicList));
            }

            @Override
            public void onFailure(Call<List<MusicModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        Button addNewSongBtn = (Button) findViewById(R.id.add_song_button);
        addNewSongBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddSongActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Call<List<MusicModel>> call =   RetrofitClient.getInstance().getApi().getMusics();
        call.enqueue(new Callback<List<MusicModel>>() {
            @Override
            public void onResponse(Call<List<MusicModel>> call, Response<List<MusicModel>> response) {
                List<MusicModel> musicList = response.body();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new MusicAdapter(getApplicationContext(),musicList));
            }

            @Override
            public void onFailure(Call<List<MusicModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}