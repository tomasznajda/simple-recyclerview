package com.tomasznajda.simplerecyclerview.adapter

import com.tomasznajda.simplerecyclerview.adapter._base.BaseSrvAdapter

class BasicSrvAdapter : BaseSrvAdapter() {

    var items: List<Any>
        get() = displayedItems
        set(value) {
            displayedItems = value
            notifyDataSetChanged()
        }
}