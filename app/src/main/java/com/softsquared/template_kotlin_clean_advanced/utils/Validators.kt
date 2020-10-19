package com.softsquared.template_kotlin_clean_advanced.utils

import java.util.regex.Pattern

object Validators {
    fun String?.isValidEmail(): Boolean {
        if (this == null) return false
        return Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", this)
    }

    fun String?.isValidPw(): Boolean {
        if (this == null) return false
        return Pattern.matches("^[0-9a-zA-Z]{4,20}$", this)
    }

    fun String?.isValidBirth(): Boolean {
        if (this == null) return false
        return Pattern.matches("^(19|20)[0-9]{2}-(([01][0-9])|10|11|12)-(([012][0-9])|30|31)$", this)
    }
}