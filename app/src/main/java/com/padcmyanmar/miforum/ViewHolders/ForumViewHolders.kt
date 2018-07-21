package com.padcmyanmar.miforum.ViewHolders

import android.view.View
import com.bumptech.glide.Glide
import com.padcmyanmar.miforum.Data.HealthCareInfoVO
import com.padcmyanmar.miforum.Delegate.HealthCareDelegate
import kotlinx.android.synthetic.main.viewholder_forum.view.*

class ForumViewHolders(itemView: View, private val mItemDelegate: HealthCareDelegate)
    : BaseForumViewHolder<HealthCareInfoVO>(itemView) {
    override fun onClick(v: View?) {
        mItemDelegate.onTabHealthCare(mData)
    }

    override fun setData(data: HealthCareInfoVO) {
        mData = data

        Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.iv_review)

        itemView.tv_title!!.text=data.title
    }

}