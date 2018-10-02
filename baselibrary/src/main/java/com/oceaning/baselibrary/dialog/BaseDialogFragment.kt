package com.oceaning.baselibrary.dialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.view.*
import com.oceaning.baselibrary.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * Created by ankeranker on 2018/9/2.
 */
abstract class BaseDialogFragment:DialogFragment(){
    /**
     * dialog根布局
     */
    protected lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 设置dialog全屏
        // setStyle(DialogFragment.STYLE_NO_TITLE,
        // android.R.style.Theme_Holo_Light_Dialog_MinWidth);
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AnkoLogger("anim").error("root")
        root = inflater.inflate(getDialogLayoutId(), container, false)
        // 去掉标题
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        // 设置背景透明
        dialog.window!!.setBackgroundDrawable(ColorDrawable(resources.getColor(R
                .color.transparent)))
        if (showBottomAnimation()) {
            val window = this.dialog.window
            //去掉dialog默认的padding

            window!!.decorView.setPadding(0, paddingTop(), 0, 0)
            val lp = window.attributes
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = if (isFullScreen())
                WindowManager.LayoutParams.MATCH_PARENT
            else
                WindowManager
                        .LayoutParams.WRAP_CONTENT
            //设置dialog的位置在底部
            lp.gravity = Gravity.BOTTOM
            //设置dialog的动画
            lp.windowAnimations = R.style.BottomDialogAnimation
            window.attributes = lp
        }
        initData()
        initEventListener()
        return root
    }

    fun isFullScreen(): Boolean {
        return false
    }

    override fun onStart() {
        super.onStart()


        val window = dialog.window
        val windowParams = window!!.attributes

        windowParams.dimAmount = dimAmount()

        window.attributes = windowParams

        // 设置宽度为屏幕宽度的百分比
        if (!showBottomAnimation()) {
            setDialogWidthHeight()
        }
    }


    open fun dimAmount(): Float {

        return 0f
    }

    open fun setDialogWidthHeight() {
        dialog.window!!.setLayout((resources.displayMetrics
                .widthPixels * 0.8).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun show(manager: FragmentManager, tag: String) {
        try {
            if (!isAdded) {
                AnkoLogger("anim").error("show")

                super.show(manager, tag)
            }
        } catch (exception: IllegalStateException) {
            exception.printStackTrace()
        }

    }

    override fun dismiss() {
        dismissAllowingStateLoss()
    }


    /**
     * 绑定数据
     */
    protected abstract fun initData()

    /**
     * 绑定监听事件
     */
    protected abstract fun initEventListener()

    protected abstract fun getDialogLayoutId(): Int

    protected fun paddingTop(): Int {
        return 0
    }

    protected fun showBottomAnimation(): Boolean {
        return false
    }

}