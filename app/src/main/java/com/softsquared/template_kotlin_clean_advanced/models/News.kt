package com.softsquared.template_kotlin_clean_advanced.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class News (
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("author") val author: String,
    @SerializedName("content") val content: String,
    @SerializedName("createdAt") val createdAt: String,
)