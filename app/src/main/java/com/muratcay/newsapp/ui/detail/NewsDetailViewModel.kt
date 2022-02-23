package com.muratcay.newsapp.ui.detail

import androidx.lifecycle.ViewModel
import com.muratcay.newsapp.data.remote.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel
@Inject constructor(private val repository: NewsRepository) : ViewModel() {

}