package com.tomasznajda.simplerecyclerview.util

fun <ItemT : Any> List<ItemT>.insert(item: ItemT, position: Int? = null) =
        toMutableList().apply { position?.let { add(it, item) } ?: add(item) }

fun <ItemT : Any> List<ItemT>.insert(items: List<ItemT>, positionStart: Int? = null) =
        toMutableList().apply { positionStart?.let { addAll(it, items) } ?: addAll(items) }

fun <ItemT : Any> List<ItemT>.remove(position: Int) =
        toMutableList().apply { removeAt(position) }

fun <ItemT : Any> List<ItemT>.move(fromPosition: Int, toPosition: Int): List<ItemT> {
    val mutableItems = toMutableList()
    val item = mutableItems[fromPosition]
    mutableItems.removeAt(fromPosition)
    mutableItems.add(toPosition, item)
    return mutableItems
}

fun <ItemT : Any> List<ItemT>.replace(item: ItemT, position: Int): List<ItemT> {
    val mutableItems = toMutableList()
    mutableItems.removeAt(position)
    mutableItems.add(position, item)
    return mutableItems
}