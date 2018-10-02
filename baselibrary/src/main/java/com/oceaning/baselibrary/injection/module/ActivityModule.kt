package com.oceaning.baselibrary.injection.module

import android.support.v7.app.AppCompatActivity
import com.oceaning.baselibrary.injection.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by ankeranker on 2018/8/14.
 */

@Module
class ActivityModule(private val activity: AppCompatActivity) {
    @ActivityScope
    @Provides
    fun providesActivity():AppCompatActivity{
        return activity
    }
}