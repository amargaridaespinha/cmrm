package com.example.catgallery.network

import com.example.catgallery.model.CatImage
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApiService {

    @GET("v1/images/search?limit=20")
    suspend fun getImages(@Query("nocache") nocache: Long): List<CatImage>
}