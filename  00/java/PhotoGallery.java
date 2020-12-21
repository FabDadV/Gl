package com.example.g;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.g.api.FlickrApi;
import com.example.g.api.ServiceAPI;
import com.example.g.model.Photo;
import com.example.g.model.PhotosResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoGallery extends AppCompatActivity {
    private RecyclerView recyclerView;
    RvAdapter adapter;
    private List<Photo> photos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        FlickrApi flickrApi = ServiceAPI.getRetrofit().create(FlickrApi.class);
        Call<PhotosResponse> call;
        call = flickrApi.getRecent();
        call.enqueue(new Callback<PhotosResponse>() {
            @Override
            public void onResponse(Call<PhotosResponse> call, Response<PhotosResponse> response) {
                if (response.isSuccessful()) {
                    PhotosResponse photosResponse = response.body();
                    photos = photosResponse.getPhotos().getPhoto();
                    adapter = new RvAdapter(photos);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<PhotosResponse> call, Throwable t) {
                Toast.makeText(PhotoGallery.this, "BAD", Toast.LENGTH_SHORT).show();
            }
        });
    }
}