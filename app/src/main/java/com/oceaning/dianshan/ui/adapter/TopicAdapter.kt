package com.oceaning.dianshan.ui.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.utils.GlideUtils
import com.oceaning.dianshan.R
import kotlinx.android.synthetic.main.layout_topic_item.view.*

/**
 * Created by ankeranker on 2018/10/4.
 */
class TopicAdapter(private val context:Context,private val list:List<String>) :PagerAdapter() {
    override fun isViewFromObject(view: View, view1: Any): Boolean {
        return view==view1
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun destroyItem(container: ViewGroup, position: Int,view: Any) {
        container.removeView(view as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val root=LayoutInflater.from(context).inflate(R.layout.layout_topic_item,null)
        GlideUtils.loadImage(context,list[position],root.mTopicIv)
        container.addView(root)
        return root
    }
}