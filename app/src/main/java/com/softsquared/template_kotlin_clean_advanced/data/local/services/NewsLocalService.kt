package com.softsquared.template_kotlin_clean_advanced.data.local.services

import android.app.Application
import com.softsquared.template_kotlin_clean_advanced.data.local.AppDatabase
import com.softsquared.template_kotlin_clean_advanced.models.News
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class NewsLocalService(application: Application) {
    val dao = AppDatabase.getInstance(application).newsDao()

    fun getSavedNews(): Single<List<News>> {
        return dao.getAllNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun saveNewses(newses: List<News>): Completable {
        return dao.insertNewses(newses)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}