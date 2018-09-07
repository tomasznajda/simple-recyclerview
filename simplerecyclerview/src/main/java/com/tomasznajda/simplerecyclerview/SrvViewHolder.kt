package com.tomasznajda.simplerecyclerview

interface SrvViewHolder<ItemT : Any> {
    fun bind(item: ItemT)
    fun unbind() = Unit
}