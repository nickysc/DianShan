package com.oceaning.baselibrary.injection.module

import android.support.v7.app.AppCompatActivity
import com.oceaning.baselibrary.injection.scope.ActivityScope
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * Created by ankeranker on 2018/8/14.
 */

@Module
class RxLifeModule(private val lifecycleProvider: LifecycleProvider<*>) {
    @ActivityScope
    @Provides
    fun providesRxLife(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}