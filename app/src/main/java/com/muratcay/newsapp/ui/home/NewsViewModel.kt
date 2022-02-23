package com.muratcay.newsapp.ui.home

import androidx.lifecycle.ViewModel
import com.muratcay.newsapp.data.remote.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel
@Inject constructor(private val repository: NewsRepository) : ViewModel() {

}