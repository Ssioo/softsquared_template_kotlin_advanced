package com.softsquared.template_kotlin_clean_advanced.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.softsquared.template_kotlin_clean_advanced.data.local.daos.NewsDao
import com.softsquared.template_kotlin_clean_advanced.models.News
import com.softsquared.template_kotlin_clean_advanced.utils.Constants

@Database(entities = [News::class], exportSchema = false, version = Constants.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "TemplateApp.db"
            ).build().also { INSTANCE = it }
        }
    }

    abstract fun newsDao(): NewsDao
}