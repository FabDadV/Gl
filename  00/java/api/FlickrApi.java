package com.example.g.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.example.g.model.PhotosResponse;

public interface FlickrApi {
    // String apiKey = getResources().getString(R.string.api_key);

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=d787eed8b71d6af8e4cd273cf63a731c&extras=url_n&format=json&nojsoncallback=1")
    Call<PhotosResponse> getRecent();
}
