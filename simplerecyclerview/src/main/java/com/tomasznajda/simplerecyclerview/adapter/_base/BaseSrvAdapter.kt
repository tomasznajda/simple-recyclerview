package com.tomasznajda.simplerecyclerview.adapter._base

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.tomasznajda.simplerecyclerview.SrvViewHolder
import com.tomasznajda.simplerecyclerview.exception.IllegalTypeOfViewHolderException
import com.tomasznajda.simplerecyclerview.exception.ViewHolderNotRegisteredException
import com.tomasznajda.simplerecyclerview.util.inflate
import kotlin.reflect.KClass

abstract class BaseSrvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var holders = mutableMapOf<Int, Pair<Int, (View) -> RecyclerView.ViewHolder>>()
    protected open var displayedItems = emptyList<Any>()

    fun <ItemT : Any, HolderT : RecyclerView.ViewHolder> addViewHolder(itemClass: KClass<ItemT>, @LayoutRes layoutRes: Int, factory: (View) -> HolderT) {
        holders[itemClass.hashCode()] = layoutRes to factory
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            holders[viewType]
                    ?.let { (layoutRes, factory) -> factory(parent.inflate(layoutRes)) }
                    ?: throw ViewHolderNotRegisteredException(getItemClassName(viewType))

    @Suppress("UNCHECKED_CAST")
    final override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
            (holder as? SrvViewHolder<Any>)?.bind(displayedItems[position])
                    ?: throw IllegalTypeOfViewHolderException(holder.javaClass.simpleName)

    final override fun getItemCount() = displayedItems.size

    final override fun getItemViewType(position: Int) = displayedItems[position]::class.hashCode()

    private fun getItemClassName(viewType: Int) =
            displayedItems.find { it::class.hashCode() == viewType }?.javaClass?.simpleName
}