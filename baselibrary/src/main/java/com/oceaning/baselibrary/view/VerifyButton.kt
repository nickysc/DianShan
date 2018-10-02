package com.kotlin.base.widgets

import android.content.Context
import android.os.Handler
import android.util.AttributeSet
import android.widget.Button
import com.oceaning.baselibrary.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/*
    获取验证码按钮
    带倒计时
 */
class VerifyButton(mContext: Context, attrs: AttributeSet) : Button(mContext, attrs) {
    private val mHandler: Handler = Handler()
    private var mCount = 60
    private var mOnVerifyBtnClick: OnVerifyBtnClick? = null

    init {
        this.text = "获取验证码"

    }

    /*
        倒计时，并处理点击事件
     */
    fun requestSendVerifyNumber() {
        AnkoLogger("register").error("requestSendVerifyNumber")

        mHandler.post(countDown)
        if (mOnVerifyBtnClick != null) {
            mOnVerifyBtnClick?.onClick()
        }

    }

    /*
        倒计时
     */
    private val countDown = object : Runnable {
        override fun run() {

            text = mCount.toString() + "s "
            AnkoLogger("register").error("text")

            setBackgroundColor(resources.getColor(R.color.common_disable))
            setTextColor(resources.getColor(R.color.common_white))
            isEnabled = false

            if (mCount > 0) {
                mHandler.postDelayed(this, 1000)
            } else {
                resetCounter()
            }
            mCount--
        }
    }

    fun removeRunable() {
        mHandler.removeCallbacks(countDown)
    }

    /*
        恢复到初始状态
     */
    fun resetCounter(vararg text: String) {
        this.isEnabled = true
        if (text.isNotEmpty() && "" != text[0]) {
            this.text = text[0]
        } else {
            this.text = "重获验证码"
        }
        this.setBackgroundColor(resources.getColor(R.color.transparent))
        this.setTextColor(resources.getColor(R.color.common_blue))
        mCount = 60
    }

    /*
        点击事件接口
     */
    interface OnVerifyBtnClick {
        fun onClick()
    }

    fun setOnVerifyBtnClick(onVerifyBtnClick: OnVerifyBtnClick) {
        this.mOnVerifyBtnClick = onVerifyBtnClick
    }
}
