package com.softsquared.template_kotlin_clean_advanced.utils

sealed class Union2<out T, out S> {
    data class A<T>(val data: T): Union2<T, Nothing>()
    data class B<S>(val data: S): Union2<Nothing, S>()
}

sealed class Union3<out T, out S, out F> {
    data class A<T>(val data: T): Union3<T, Nothing, Nothing>()
    data class B<S>(val data: S): Union3<Nothing, S, Nothing>()
    data class C<F>(val data: F): Union3<Nothing, Nothing, F>()
}