package com.muratcay.newsapp.data.remote.repository

import com.muratcay.newsapp.data.model.ArticlesResponse
import com.muratcay.newsapp.data.remote.service.NewsService
import javax.inject.Inject

class NewsRepository
@Inject constructor(private val newsService: NewsService) {

    suspend fun getTopHeadlines(): ArticlesResponse =
        newsService.getTopHeadlines()

}