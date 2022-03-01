package com.muratcay.newsapp.ui.viewstate

import com.muratcay.newsapp.data.model.Article

data class NewsDetailViewStateScreen(val article: Article) {

    fun getTitle() = article.title

    fun getDescription() = article.description

    fun getImageUrl() = article.urlToImage
}
