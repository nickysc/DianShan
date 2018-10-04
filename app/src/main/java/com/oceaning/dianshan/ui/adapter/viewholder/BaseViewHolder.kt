package com.oceanwing.eufylife.adapter.viewholder

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView

/**
 * Created by ankeranker on 2018/8/3.
 */
class BaseViewHolder(item:View) :RecyclerView.ViewHolder(item) {

    var mItemView=item
    private var mViews=SparseArray<View>()




    fun <T :View> getView(viewId:Int):T{
        var view=mViews.get(viewId)
        if (view == null){
            view=mItemView.findViewById(viewId)
            mViews.put(viewId,view)
        }
        return view as T
    }

    fun <T :TextView> setText(viewId : Int,content:String){
        var view=getView<T>(viewId)
        view.text=content
    }

    fun <T :View> setOnClickListener(viewId : Int,listener: View.OnClickListener){
        var view = getView<T>(viewId)
        view.setOnClickListener(listener)
    }
}