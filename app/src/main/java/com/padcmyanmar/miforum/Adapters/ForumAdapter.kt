package com.padcmyanmar.miforum.Adapters

import android.content.Context
import android.view.ViewGroup
import com.padcmyanmar.miforum.Data.HealthCareInfoVO
import com.padcmyanmar.miforum.Delegate.HealthCareDelegate
import com.padcmyanmar.miforum.R
import com.padcmyanmar.miforum.ViewHolders.ForumViewHolders

class ForumAdapter(context: Context,private val mItemDelegate:HealthCareDelegate) : BaseForumAdapter<ForumViewHolders, HealthCareInfoVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForumViewHolders {
        val itemView = mLayoutInflater.inflate(R.layout.viewholder_forum, parent, false)
        return ForumViewHolders(itemView,mItemDelegate)
}
}