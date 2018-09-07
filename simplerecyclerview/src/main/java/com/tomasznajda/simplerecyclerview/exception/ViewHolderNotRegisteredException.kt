package com.tomasznajda.simplerecyclerview.exception

class ViewHolderNotRegisteredException(itemClassName: String?)
    : Exception("There is no any ViewHolder for $itemClassName::class. " +
        "Use addViewHolder() to register ViewHolder factory. " +
        "For example: addViewHolder(User::class, R.layout.viewholder_user, { UserViewHolder(it) }) ")