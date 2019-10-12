package com.example.garimabedi.mykotlin.api

import com.example.garimabedi.mykotlin.models.PhotoList
import retrofit2.Call
import retrofit2.http.GET

interface PhotoAPI {
    @GET("?key=13772107-bf7b20ed787c8937f25ae9789&q=nature&&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}