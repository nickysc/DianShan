package com.oceaning.user.injection.component

import com.oceaning.baselibrary.injection.component.ActivityComponent
import com.oceaning.baselibrary.injection.scope.PerComponentScope
import com.oceaning.dianshan.injection.module.MainModule
import com.oceaning.dianshan.ui.activity.MainActivity
import com.oceaning.user.ui.activity.*
import dagger.Component

/**
 * Created by ankeranker on 2018/8/12.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(MainModule::class))
interface MainComponent {
    fun injects(activity:MainActivity)
}