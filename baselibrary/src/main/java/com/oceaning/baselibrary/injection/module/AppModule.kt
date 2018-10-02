package com.oceaning.baselibrary.injection.module

import android.content.Context
import com.oceaning.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by ankeranker on 2018/8/14.
 */
@Module
class AppModule(private val context:BaseApplication) {
    @Provides
    @Singleton
    fun providesContext():Context{
        return context
    }
}