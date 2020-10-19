package com.softsquared.template_kotlin_clean_advanced.utils.objects

class SingleEvent<T: Any>(var data: T, var isHandled: Boolean = false) {
    fun get(): T? {
        if (isHandled) return null
        isHandled = true
        return data
    }
}