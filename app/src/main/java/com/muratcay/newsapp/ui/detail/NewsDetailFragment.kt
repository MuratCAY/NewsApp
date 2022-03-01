package com.muratcay.newsapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.muratcay.newsapp.R
import com.muratcay.newsapp.databinding.FragmentNewsDetailBinding
import com.muratcay.newsapp.ui.base.BaseFragment
import com.muratcay.newsapp.ui.viewstate.NewsDetailViewStateScreen


class NewsDetailFragment : BaseFragment<FragmentNewsDetailBinding>() {

    private val safeArgs: NewsDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        safeArgs.selectedArticle.let { article ->
            binding.newsDetailFragmentViewState = NewsDetailViewStateScreen(article)
        }
    }


    override fun getFragmentView() = R.layout.fragment_news_detail
}