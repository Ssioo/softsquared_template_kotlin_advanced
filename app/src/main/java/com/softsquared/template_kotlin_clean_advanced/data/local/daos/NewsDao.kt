package com.softsquared.template_kotlin_clean_advanced.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softsquared.template_kotlin_clean_advanced.models.News
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(news: News): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewses(newses: List<News>): Completable

    @Query("SELECT * FROM News")
    fun getAllNews(): Single<List<News>>
}