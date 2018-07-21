package com.padcmyanmar.miforum.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcmyanmar.miforum.ViewHolders.BaseForumViewHolder

open class BaseForumAdapter<T, W>(context: Context) : RecyclerView.Adapter<BaseForumViewHolder<W>>() {
    //T န ဲ့ Wက ViewHolderနဲ့Vo ဆိုတာက ပါလာတဲ့ data အတြက္ Generic Type


    protected var mData: MutableList<W>? = null
    protected var mLayoutInflater: LayoutInflater

    init {//Constructor မွာ initalize လုပ္တဲ့ ပံုစံထဲက တစ္ခု
        mData = ArrayList()
        mLayoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseForumViewHolder<W> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BaseForumViewHolder<W>, position: Int) {
        holder.setData(mData!![position])
    }

    override fun getItemCount(): Int {
        //  return mData!!.size
        return mData!!.size
    }


    fun setNewData(newData: MutableList<W>) {
        mData = newData
        notifyDataSetChanged()
    }

    fun appendNewData(newData: List<W>) {
        mData!!.addAll(newData)
        notifyDataSetChanged()
    }

//
//    fun clearData() {
//        mData = java.util.ArrayList()
//        notifyDataSetChanged()
//    }
}