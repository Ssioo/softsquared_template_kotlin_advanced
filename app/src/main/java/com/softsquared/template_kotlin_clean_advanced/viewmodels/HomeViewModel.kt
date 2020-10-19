package com.softsquared.template_kotlin_clean_advanced.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.softsquared.template_kotlin_clean_advanced.BaseViewModel
import com.softsquared.template_kotlin_clean_advanced.data.remote.services.NewsService
import com.softsquared.template_kotlin_clean_advanced.models.News
import com.softsquared.template_kotlin_clean_advanced.utils.Helpers.toDisposal
import com.softsquared.template_kotlin_clean_advanced.views.adapters.NewsListAdapter

class HomeViewModel(application: Application) : BaseViewModel(application) {

    val newsListAdapter = NewsListAdapter(viewModel = this)

    val news: MutableLiveData<ArrayList<News?>> = MutableLiveData()

    fun tryFetchNews() {
        networkEvent.startLoading()
        NewsService().fetchNews().toDisposal(rxDisposable, {
            networkEvent.clear()
            news.value = it
        }, {
            doOnNetworkError(it)
        })
    }

    init {
        tryFetchNews()
    }
}