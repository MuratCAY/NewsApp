package com.muratcay.newsapp.ui.home

import com.muratcay.newsapp.R
import com.muratcay.newsapp.databinding.FragmentNewsBinding
import com.muratcay.newsapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>() {


    override fun getFragmentView() = R.layout.fragment_news
}