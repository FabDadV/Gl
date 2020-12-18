package com.example.g.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.example.g.model.PhotosResponse;

public interface FlickrApi {
    // String apiKey = getResources().getString(R.string.api_key);

    @GET("services/rest/?method=flickr.photos.getRecent&api_key=d787eed8b71d6af8e4cd273cf63a731c&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getRecent();

    @GET("services/rest/?method=flickr.photos.search&api_key=d787eed8b71d6af8e4cd273cf63a731c&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getSearchPhotos(@Query("text") String keyWord);

    @GET("services/rest/?method=flickr.photos.search&api_key=d787eed8b71d6af8e4cd273cf63a731c&extras=url_s&format=json&nojsoncallback=1")
    Call<PhotosResponse> getFoundPhotos(@Query("per_page") int pageCount, @Query("page") int pageNum, @Query("text") String keyWord);
}
