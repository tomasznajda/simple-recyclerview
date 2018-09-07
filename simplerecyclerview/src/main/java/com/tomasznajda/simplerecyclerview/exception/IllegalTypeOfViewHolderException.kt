package com.tomasznajda.simplerecyclerview.exception

class IllegalTypeOfViewHolderException(holderClassName: String?)
    : Exception("$holderClassName does not implement SrvViewHolder")