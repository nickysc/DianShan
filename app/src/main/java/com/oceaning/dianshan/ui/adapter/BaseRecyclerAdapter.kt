package com.oceanwing.eufylife.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oceanwing.eufylife.adapter.viewholder.BaseViewHolder

/**
 * Created by ankeranker on 2018/8/3.
 */
abstract class BaseRecyclerAdapter<T>(context:Context,dataList:MutableList<T>,layoutId:Int) :RecyclerView.Adapter<BaseViewHolder>() {

    var mDataList=dataList
    var mContext = context
    var mLayoutID = layoutId

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var view = LayoutInflater.from(mContext).inflate(mLayoutID,parent,false)
        var holder = BaseViewHolder(view)
        setItemListener(parent, holder, viewType)
        return holder
    }

    private fun setItemListener(parent: ViewGroup, holder: BaseViewHolder, viewType: Int) {
        holder.mItemView.setOnClickListener { v -> mListener?.onItemClick(v,holder,holder.adapterPosition) }
        holder.mItemView.setOnLongClickListener { v ->
            mListener?.onItemLongClick(v,holder,holder.adapterPosition)
            false
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        convert(holder,mDataList[position],position)
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }
    abstract fun convert(holder: BaseViewHolder,t :T,position: Int)


    interface OnItemClickListener{
        fun onItemClick(view: View?, holder: RecyclerView.ViewHolder, position: Int)

        fun onItemLongClick(view: View?, holder: RecyclerView.ViewHolder, position: Int): Boolean
    }

    var mListener:OnItemClickListener?=null

    fun setOnItemClickListener(listener:OnItemClickListener){
        this.mListener = listener
    }
}