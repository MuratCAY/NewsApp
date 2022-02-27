package com.muratcay.newsapp.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muratcay.newsapp.R
import com.muratcay.newsapp.data.model.Article
import com.muratcay.newsapp.ui.home.adapter.ArticleAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Article>?) {
    val adapter = recyclerView.adapter as ArticleAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView.context).load(imageUrl).apply(
            RequestOptions.placeholderOf(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
        ).into(imageView)
    }
}

@BindingAdapter("status")
fun bindStatus(statusImage: ImageView, status: Status?) {
    when (status) {
        Status.LOADING -> {
            statusImage.visibility = View.VISIBLE
            statusImage.setImageResource(R.drawable.loading_animation)
        }
        Status.SUCCESS -> statusImage.visibility = View.GONE
        else -> {
            statusImage.visibility = View.VISIBLE
            statusImage.setImageResource(R.drawable.ic_connection_error)
        }
    }
}