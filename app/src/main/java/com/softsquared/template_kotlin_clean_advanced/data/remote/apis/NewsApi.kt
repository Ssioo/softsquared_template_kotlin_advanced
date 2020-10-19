package com.softsquared.template_kotlin_clean_advanced.data.remote.apis

import com.softsquared.template_kotlin_clean_advanced.models.News
import com.softsquared.template_kotlin_clean_advanced.utils.objects.BaseResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface NewsApi {
    @GET("/users")
    fun getNews(): Single<BaseResponse<ArrayList<News?>>>
}