package com.softsquared.template_kotlin_clean_advanced.views

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.softsquared.template_kotlin_clean_advanced.BaseActivity
import com.softsquared.template_kotlin_clean_advanced.R
import com.softsquared.template_kotlin_clean_advanced.databinding.ActivityMainBinding
import com.softsquared.template_kotlin_clean_advanced.viewmodels.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override fun getViewModel(): MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {

    }
}