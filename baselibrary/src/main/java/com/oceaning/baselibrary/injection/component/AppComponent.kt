package com.oceaning.baselibrary.injection.component

import android.content.Context
import com.oceaning.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ankeranker on 2018/8/14.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context():Context
}