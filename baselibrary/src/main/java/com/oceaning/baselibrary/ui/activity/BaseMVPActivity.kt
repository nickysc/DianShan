package com.oceaning.baselibrary.ui.activity

import android.os.Bundle
import android.view.View
import com.oceaning.baselibrary.common.BaseApplication
import com.oceaning.baselibrary.dialog.LoadingDialogFragment
import com.oceaning.baselibrary.injection.component.ActivityComponent
import com.oceaning.baselibrary.injection.component.DaggerActivityComponent
import com.oceaning.baselibrary.injection.module.ActivityModule
import com.oceaning.baselibrary.injection.module.RxLifeModule
import com.oceaning.baselibrary.presenter.BasePresenter
import com.oceaning.baselibrary.presenter.view.BaseView
import com.oceaning.baselibrary.utils.showLoadingDialogFragment
import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by ankeranker on 2018/7/29.
 */
abstract class BaseMVPActivity<P:BasePresenter<*>> :BaseActivity(),BaseView , OnResponseListener,View.OnClickListener {

    var TAG=javaClass::class.java.simpleName
    @Inject
    lateinit var mPresenter:P
    private var loadingDialog:LoadingDialogFragment?=null

    override fun initOperator() {
        initActivityInjection()
    }
    lateinit var activityComponent :ActivityComponent

    private fun initActivityInjection() {

        activityComponent= DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .rxLifeModule(RxLifeModule(this))
                .build()
    }


    override fun loadend() {
        loadingDialog?.dismiss()
    }

    override fun loading() {
        loadingDialog= showLoadingDialogFragment(supportFragmentManager)
    }

    override fun onError(message: String) {
        toast(message)
    }

    override fun onBefore(d: Disposable, id: Int) {
        loading()
        AnkoLogger("aa").error("onBefore")

    }

    override fun onAfter(result:Boolean,id: Int) {
        loadend()
        AnkoLogger("aa").error("onAfter")

    }

    override fun onFailure(e: Throwable, isNet: Boolean, id: Int) {
        AnkoLogger("aa").error("onFailure:${e.toString()}")

    }

    override fun <T> onSuccess(t: T, id: Int) {
        AnkoLogger("aa").error("onSuccess")
    }

    override fun onCodeError(message:String,id: Int) {
        AnkoLogger("aa").error("onCodeError")
        toast(message)

    }

    override fun onClick(v: View?) {

    }
}