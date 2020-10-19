package com.softsquared.template_kotlin_clean_advanced.views.adapters

import com.softsquared.template_kotlin_clean_advanced.R
import com.softsquared.template_kotlin_clean_advanced.databinding.ItemNewsBinding
import com.softsquared.template_kotlin_clean_advanced.models.News
import com.softsquared.template_kotlin_clean_advanced.viewmodels.HomeViewModel

class NewsListAdapter(viewModel: HomeViewModel) :
    BaseRecyclerAdapter<News, ItemNewsBinding, HomeViewModel>(
        viewmodel = viewModel,
        layoutId = R.layout.item_news
    ) {
}