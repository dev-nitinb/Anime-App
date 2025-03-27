package com.example.animeapp.data.network

import com.example.animeapp.data.model.AnimeResponse
import retrofit2.http.GET

interface ApiService {

    @GET("top/anime")
    suspend fun getAnimeList(): AnimeResponse

}