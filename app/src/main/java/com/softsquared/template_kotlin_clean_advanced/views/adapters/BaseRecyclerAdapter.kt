package com.softsquared.template_kotlin_clean_advanced.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.softsquared.template_kotlin_clean_advanced.BaseViewModel

abstract class BaseRecyclerAdapter<I, B : ViewDataBinding, VM : BaseViewModel>(
    @LayoutRes val layoutId: Int,
    val viewmodel: VM
) :
    RecyclerView.Adapter<BaseRecyclerViewHolder<I, B>>(), IBaseRecyclerAdapter<I> {

    val items: ArrayList<I?> = ArrayList()

    override fun setItems(items: ArrayList<I?>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun addItems(items: ArrayList<I?>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun addItem(item: I?) {
        this.items.add(item)
        notifyItemChanged(items.size - 1)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<I, B> = object : BaseRecyclerViewHolder<I, B>(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), layoutId, parent, false
        )
    ) {
        override fun initItem(item: I) {}
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<I, B>, position: Int) {
        items.get(position)?.let { holder.bindTo(it) }
    }

    override fun getItemCount(): Int = items.size
}

interface IBaseRecyclerAdapter<I> {
    fun setItems(items: ArrayList<I?>)

    fun addItems(items: ArrayList<I?>)

    fun addItem(item: I?)
}