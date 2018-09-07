package com.tomasznajda.simplerecyclerview.adapter

import com.tomasznajda.simplerecyclerview.adapter._base.BaseSrvAdapter
import com.tomasznajda.simplerecyclerview.util.insert
import com.tomasznajda.simplerecyclerview.util.move
import com.tomasznajda.simplerecyclerview.util.remove
import com.tomasznajda.simplerecyclerview.util.replace

class AdvancedSrvAdapter : BaseSrvAdapter() {

    fun <ItemT : Any> set(items: List<ItemT>) {
        displayedItems = items
        notifyDataSetChanged()
    }

    fun <ItemT : Any> insert(item: ItemT, position: Int? = null) {
        displayedItems = displayedItems.insert(item, position)
        notifyItemInserted(position ?: displayedItems.size)
    }

    fun <ItemT : Any> insert(items: List<ItemT>, positionStart: Int? = null) {
        displayedItems = displayedItems.insert(items, positionStart)
        notifyItemRangeInserted(positionStart ?: displayedItems.size, items.size)
    }

    fun <ItemT : Any> remove(item: ItemT) {
        displayedItems.indexOf(item).let { remove(it) }
    }

    fun remove(position: Int) {
        displayedItems = displayedItems.remove(position)
        notifyItemRemoved(position)
    }

    fun <ItemT : Any> move(item: ItemT, toPosition: Int) {
        displayedItems.indexOf(item).let { move(it, toPosition) }
    }

    fun move(fromPosition: Int, toPosition: Int) {
        displayedItems = displayedItems.move(fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    fun <ItemT : Any> replace(item: ItemT, position: Int) {
        displayedItems = displayedItems.replace(item, position)
        notifyItemChanged(position)
    }

}