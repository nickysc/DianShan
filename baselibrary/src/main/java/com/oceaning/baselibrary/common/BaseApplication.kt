package com.oceaning.baselibrary.common

import android.app.Application
import android.content.Context
import com.oceaning.baselibrary.injection.component.AppComponent
import com.oceaning.baselibrary.injection.component.DaggerAppComponent
import com.oceaning.baselibrary.injection.module.AppModule

/**
 * Created by ankeranker on 2018/8/14.
 */
class BaseApplication :Application() {

     lateinit var appComponent:AppComponent

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context=this
    }

    private fun initAppInjection() {
       appComponent= DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}