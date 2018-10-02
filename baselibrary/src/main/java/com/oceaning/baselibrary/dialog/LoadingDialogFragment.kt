package com.oceaning.baselibrary.dialog

import android.graphics.drawable.AnimationDrawable
import android.media.Image
import android.support.v4.app.FragmentManager
import android.widget.ImageView
import com.oceaning.baselibrary.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.find

/**
 * Created by ankeranker on 2018/9/2.
 */
class LoadingDialogFragment:BaseDialogFragment(){

    private var animationDrawable:AnimationDrawable?=null
    override fun initData() {

        var img=root.findViewById<ImageView>(R.id.iv_loading)
        animationDrawable= img.background as AnimationDrawable
        animationDrawable?.start()

    }

    override fun initEventListener() {
    }

    override fun getDialogLayoutId(): Int {
        return R.layout.progress_dialog
    }

    override fun setDialogWidthHeight() {
        dialog.window?.setLayout((resources.displayMetrics
                .widthPixels * 0.3).toInt(), (resources.displayMetrics
                .widthPixels * 0.3).toInt())
    }

    override fun dimAmount(): Float {
        return 0.4f
    }

    override fun show(manager: FragmentManager, tag: String) {

        super.show(manager, tag)

    }

    override fun dismiss() {
        animationDrawable?.stop()
        super.dismiss()


    }
}