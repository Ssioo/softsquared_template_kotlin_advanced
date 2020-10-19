package com.softsquared.template_kotlin_clean_advanced.views.adapters

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template_kotlin_clean_advanced.BR

abstract class BaseRecyclerViewHolder<I, B: ViewDataBinding>(val binding: B)
    : RecyclerView.ViewHolder(binding.root), IBaseRecyclerViewHolder<I> {
    override fun bindTo(item: I) {
        binding.setVariable(BR.item, item)
        initItem(item)
    }

}

interface IBaseRecyclerViewHolder<I> {
    fun bindTo(item: I)

    fun initItem(item: I)
}