package com.tomasznajda.simplerecyclerview.sample.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.tomasznajda.simplerecyclerview.SrvViewHolder
import com.tomasznajda.simplerecyclerview.sample.entity.Advertisement
import kotlinx.android.synthetic.main.viewholder_ad.view.*

class AdvertisementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SrvViewHolder<Advertisement> {

    override fun bind(item: Advertisement) {
        itemView.ad.text = item.url
    }
}