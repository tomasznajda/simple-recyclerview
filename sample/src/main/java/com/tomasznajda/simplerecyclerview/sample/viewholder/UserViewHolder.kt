package com.tomasznajda.simplerecyclerview.sample.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.tomasznajda.simplerecyclerview.SrvViewHolder
import com.tomasznajda.simplerecyclerview.sample.entity.User
import kotlinx.android.synthetic.main.viewholder_user.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SrvViewHolder<User> {

    override fun bind(item: User) {
        itemView.title.text = item.name
    }
}