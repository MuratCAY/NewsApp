package com.muratcay.newsapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muratcay.newsapp.data.model.Article
import com.muratcay.newsapp.data.remote.repository.NewsRepository
import com.muratcay.newsapp.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val mutableStatus: MutableLiveData<Status> = MutableLiveData()
    val status: LiveData<Status>
        get() = mutableStatus

    private val mutableArticle: MutableLiveData<List<Article>> = MutableLiveData()
    val article: LiveData<List<Article>>
        get() = mutableArticle

    private val mutableNavigateSelectedArticle: MutableLiveData<Article?> = MutableLiveData()
    val navigateSelectedArticle: LiveData<Article?>
        get() = mutableNavigateSelectedArticle

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            mutableStatus.value = Status.LOADING
            try {
                mutableArticle.value = repository.getTopHeadlines().articles
                mutableStatus.value = Status.SUCCESS
            } catch (e: Exception) {
                mutableStatus.value = Status.ERROR
                mutableArticle.value = ArrayList()
            }
        }
    }

    fun displayArticleDetails(article: Article?) {
        mutableNavigateSelectedArticle.value = article
    }

    fun displayArticleDetailComplete() {
        mutableNavigateSelectedArticle.value = null
    }
}