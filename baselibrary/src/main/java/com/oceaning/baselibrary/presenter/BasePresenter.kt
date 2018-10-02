package com.oceaning.baselibrary.presenter

import android.content.Context
import com.kotlin.base.utils.NetWorkUtils
import com.oceaning.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle2.LifecycleProvider
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import javax.inject.Inject

/**
 * Created by ankeranker on 2018/7/29.
 */
open class BasePresenter<V:BaseView> {

    lateinit var mView:V
    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>
    @Inject
    lateinit var context:Context

    fun isNetWorkAvailable():Boolean{
        if (NetWorkUtils.isNetWorkAvailable(context)){
            LogE("register","success")

            return true
        }
        LogE("register","faile")
        mView.onError("net is't available")
        return false
    }

    fun LogE(tag:String,message:String){
        AnkoLogger(tag).error(message)
    }
}