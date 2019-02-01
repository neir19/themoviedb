package com.example.nei.themoviedb.service;

import com.example.nei.themoviedb.Model.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("/3/movie/popular")
Call<Movie> getPopulaMovies     (@Query("api_key") String ApiKey, @Query("page") int page);
    @GET("/3/movie/top_rated")
Call<Movie> getTopMovies        (@Query("api_key") String ApiKey, @Query("page") int page);
    @GET("/3/movie/upcoming")
Call<Movie> getUpcomingMovies   (@Query("api_key") String ApiKey, @Query("page") int page);

}
