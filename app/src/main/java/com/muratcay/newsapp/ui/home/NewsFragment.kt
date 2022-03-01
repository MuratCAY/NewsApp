package com.muratcay.newsapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.muratcay.newsapp.R
import com.muratcay.newsapp.databinding.FragmentNewsBinding
import com.muratcay.newsapp.ui.base.BaseFragment
import com.muratcay.newsapp.ui.home.adapter.ArticleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding>() {

    private val viewModel: NewsViewModel by viewModels()
    private val articlesAdapter: ArticleAdapter by lazy { ArticleAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        configureRecycler()
        navigateSelectedArticle()
    }

    private fun configureRecycler() {
        binding.recyclerView.adapter = articlesAdapter
    }

    private fun navigateSelectedArticle() {

        articlesAdapter.onClick = {
            viewModel.displayArticleDetails(it)
        }

        viewModel.navigateSelectedArticle.observe(viewLifecycleOwner) { articleModel ->
            articleModel?.let {
                findNavController().navigate(
                    NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(
                        it
                    )
                )
                viewModel.displayArticleDetailComplete()
            }
        }
    }

    override fun getFragmentView() = R.layout.fragment_news
}