package com.muratcay.newsapp.data.remote.repository

import com.muratcay.newsapp.data.model.ArticlesResponse
import com.muratcay.newsapp.data.remote.service.NewsService
import com.muratcay.newsapp.utils.Constants
import javax.inject.Inject

class NewsRepository
@Inject constructor(private val newsService: NewsService) {
    suspend fun getTopHeadlines(): ArticlesResponse =
        newsService.getTopHeadlines(country = "tr", apiKey = Constants.api_key)
}