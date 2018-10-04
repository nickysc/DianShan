package com.oceaning.dianshan.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.mall.common.*
import com.oceaning.dianshan.R
import com.oceaning.dianshan.banner.GlideImageLoader
import com.oceaning.dianshan.ui.adapter.HomeDiscountAdapter
import com.oceaning.dianshan.ui.adapter.TopicAdapter
import me.crosswall.lib.coverflow.CoverFlow

/**
 * Created by ankeranker on 2018/10/4.
 */
class MeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root = inflater.inflate(R.layout.fragment_me, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}