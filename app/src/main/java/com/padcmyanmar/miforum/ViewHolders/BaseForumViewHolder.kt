package com.padcmyanmar.miforum.ViewHolders

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseForumViewHolder<W>(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    protected var mData: W? = null

    init {
        itemView.setOnClickListener(this)
    }

    abstract fun setData(data: W)
}