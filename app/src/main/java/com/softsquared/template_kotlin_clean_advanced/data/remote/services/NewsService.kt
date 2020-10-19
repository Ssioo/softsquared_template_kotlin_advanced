package com.softsquared.template_kotlin_clean_advanced.data.remote.services

import com.softsquared.template_kotlin_clean_advanced.ApplicationClass
import com.softsquared.template_kotlin_clean_advanced.data.remote.apis.NewsApi
import com.softsquared.template_kotlin_clean_advanced.models.News
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsService {

    fun fetchNews(): Single<ArrayList<News?>> {
        return ApplicationClass.retrofit.create(NewsApi::class.java)
            .getNews()
            .map { if (it.isSuccess) it.data ?: arrayListOf() else throw Exception("Load Failure") }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}