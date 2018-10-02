package com.oceaning.baselibrary.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.oceaning.baselibrary.R
import kotlinx.android.synthetic.main.layout_header_bar.view.*

/**
 * Created by ankeranker on 2018/8/26.
 */
class HeaderBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var isShowBack=true
    var titleText:String?=null
    var rightText:String?=null
    init {
        var typedArray=context.obtainStyledAttributes(attrs, R.styleable.HeaderBar)
        isShowBack=typedArray.getBoolean(R.styleable.HeaderBar_isShowBack,true)
        titleText=typedArray.getString(R.styleable.HeaderBar_titleText)
        rightText=typedArray.getString(R.styleable.HeaderBar_rightText)
        typedArray.recycle()
        initView()
    }

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.layout_header_bar,this,true)
        //View.inflate(context,R.layout.layout_header_bar,this)
        mLeftIv.visibility=if(isShowBack) View.VISIBLE else View.GONE
        mTitleTv?.let {
            it.text=titleText
        }
        mRightTv?.let {
            it.text=rightText
            it.visibility=View.VISIBLE
        }
        mLeftIv.setOnClickListener{
            if (context is Activity){
                (context as Activity).finish()
            }
        }
    }

    fun getRightTv():TextView{
        return mRightTv
    }
}