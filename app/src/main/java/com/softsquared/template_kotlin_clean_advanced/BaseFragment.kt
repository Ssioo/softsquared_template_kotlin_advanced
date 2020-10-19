package com.softsquared.template_kotlin_clean_advanced

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel, PVM : BaseViewModel>(@LayoutRes val layoutId: Int) :
    Fragment(layoutId), IBaseFragment<VM, PVM> {

    protected lateinit var binding: B
    protected lateinit var vm: VM
    protected lateinit var pvm: PVM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        vm = getViewModel()
        pvm = getParentViewModel()
        binding.setVariable(BR.vm, vm)
        binding.setVariable(BR.pvm, pvm)
        binding.lifecycleOwner = this

        initView(savedInstanceState)
    }
}

interface IBaseFragment<VM : BaseViewModel, PVM : BaseViewModel> {
    fun getViewModel(): VM

    fun getParentViewModel(): PVM

    fun initView(savedInstanceState: Bundle?)
}