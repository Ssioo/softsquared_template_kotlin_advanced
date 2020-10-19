package com.softsquared.template_kotlin_clean_advanced.views

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.softsquared.template_kotlin_clean_advanced.BaseFragment
import com.softsquared.template_kotlin_clean_advanced.R
import com.softsquared.template_kotlin_clean_advanced.databinding.FragmentHomeBinding
import com.softsquared.template_kotlin_clean_advanced.viewmodels.HomeViewModel
import com.softsquared.template_kotlin_clean_advanced.viewmodels.MainViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel, MainViewModel>(
    R.layout.fragment_home
) {
    override fun getViewModel(): HomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun getParentViewModel(): MainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

    override fun initView(savedInstanceState: Bundle?) {
        binding.rvHome.adapter = vm.newsListAdapter
        vm.news.observe(this) { vm.newsListAdapter.setItems(it) }
    }
}