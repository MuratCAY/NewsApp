package com.muratcay.newsapp.data.remote.service

import com.muratcay.newsapp.data.model.ArticlesResponse
import com.muratcay.newsapp.utils.Constants.api_key
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "tr",
        @Query("apiKey") apiKey: String = api_key
    ): ArticlesResponse
}