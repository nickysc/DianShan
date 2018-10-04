package com.oceaning.baselibrary.view

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem.SHAPE_OVAL
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.oceaning.baselibrary.R

/**
 * Created by ankeranker on 2018/10/3.
 */
class BottomNavBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {


    private lateinit var mTextBadgeItem:TextBadgeItem

    private lateinit var mShapeBadgeItem:ShapeBadgeItem

    init {
        var homeItem=BottomNavigationItem(R.drawable.btn_nav_home_press,
                resources.getString(R.string.nav_bar_home))
                .setInactiveIconResource(R.drawable.btn_nav_home_normal)
                .setInActiveColor(R.color.common_blue)
                .setActiveColor(R.color.text_normal)

        var listItem=BottomNavigationItem(R.drawable.btn_nav_category_press,
                resources.getString(R.string.nav_bar_category))
                .setInactiveIconResource(R.drawable.btn_nav_category_normal)
                .setInActiveColor(R.color.common_blue)
                .setActiveColor(R.color.text_normal)

        var carItem=BottomNavigationItem(R.drawable.btn_nav_cart_press,
                resources.getString(R.string.nav_bar_cart))
                .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
                .setInActiveColor(R.color.common_blue)
                .setActiveColor(R.color.text_normal)

        mTextBadgeItem= TextBadgeItem()
        carItem.setBadgeItem(mTextBadgeItem)

        var msgItem=BottomNavigationItem(R.drawable.btn_nav_msg_press,
                resources.getString(R.string.nav_bar_msg))
                .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
                .setInActiveColor(R.color.common_blue)
                .setActiveColor(R.color.text_normal)

        mShapeBadgeItem= ShapeBadgeItem()
        mShapeBadgeItem.setShape(SHAPE_OVAL)
        msgItem.setBadgeItem(mShapeBadgeItem)

        var meItem=BottomNavigationItem(R.drawable.btn_nav_user_press,
                resources.getString(R.string.nav_bar_user))
                .setInactiveIconResource(R.drawable.btn_nav_user_normal)
                .setInActiveColor(R.color.common_blue)
                .setActiveColor(R.color.text_normal)


        setMode(MODE_FIXED)
        setBackgroundStyle(BACKGROUND_STYLE_DEFAULT)
        //setBarBackgroundColor(R.color.common_white)


        addItem(homeItem)
                .addItem(listItem)
                .addItem(carItem)
                .addItem(msgItem)
                .addItem(meItem)
                .setFirstSelectedPosition(0)
                .initialise()
    }


    fun setTextBadgeSize(count:Int){
        if (count==0){
            mTextBadgeItem.hide()
        }else{
            mTextBadgeItem.show()
            mTextBadgeItem.setText("$count")
        }
    }

    fun isHaveMsg(haveMsg:Boolean){
        if(haveMsg){
            mShapeBadgeItem.show()
        }else{
            mShapeBadgeItem.hide()
        }
    }
}