package com.oceaning.baselibrary.injection.component

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.oceaning.baselibrary.injection.module.ActivityModule
import com.oceaning.baselibrary.injection.module.RxLifeModule
import com.oceaning.baselibrary.injection.scope.ActivityScope
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component

/**
 * Created by ankeranker on 2018/8/14.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class, RxLifeModule::class))
interface ActivityComponent {
    fun context(): Context
    fun activity():AppCompatActivity
    fun lifecycleProvider(): LifecycleProvider<*>



}