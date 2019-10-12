package com.example.garimabedi.mykotlin.api

import com.example.garimabedi.mykotlin.models.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoRetriever {
    private val service : PhotoAPI

    init {
        // create the retrofit client
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.pixabay.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // create service
        service = retrofit.create(PhotoAPI::class.java)
    }

    fun getPhotos(callback: Callback<PhotoList>) {
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}