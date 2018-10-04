package com.oceaning.dianshan.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView.HORIZONTAL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.mall.common.*
import com.oceaning.dianshan.R
import com.oceaning.dianshan.banner.GlideImageLoader
import com.oceaning.dianshan.ui.adapter.HomeDiscountAdapter
import com.oceaning.dianshan.ui.adapter.TopicAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow


/**
 * Created by ankeranker on 2018/10/4.
 */
class HomeFragment :Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var root=inflater.inflate(R.layout.fragment_home,container,false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBanner()
        initNews()
        initDiscount()
        initTopic()
    }

    private fun initTopic() {
        mTopicPager.adapter = TopicAdapter(context!!, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5

        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build()
    }

    private fun initDiscount() {

        val manager=LinearLayoutManager(activity)
        manager.orientation=HORIZONTAL
        mHomeDiscountRv.layoutManager=manager
        var data= mutableListOf<String>()
        data.add(HOME_DISCOUNT_ONE)
        data.add(HOME_DISCOUNT_TWO)
        data.add(HOME_DISCOUNT_THREE)
        data.add(HOME_DISCOUNT_FOUR)
        data.add(HOME_DISCOUNT_FIVE)
        mHomeDiscountRv.adapter=HomeDiscountAdapter(context!!,data,R.layout.layout_home_discount_item)
    }

    private fun initNews() {
        mNewsFlipperView.setData(arrayOf("新用户注册福利","炎炎夏日，需要来一发"))

    }

    private fun initBanner() {
        //设置图片加载器
        mHomeBanner.setImageLoader(GlideImageLoader())
        //设置图片集合
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start()

    }
}