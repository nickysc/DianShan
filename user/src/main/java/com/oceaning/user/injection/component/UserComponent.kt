package com.oceaning.user.injection.component

import com.oceaning.baselibrary.injection.component.ActivityComponent
import com.oceaning.baselibrary.injection.scope.PerComponentScope
import com.oceaning.user.injection.module.UserModule
import com.oceaning.user.ui.activity.ForgetPwdActivity
import com.oceaning.user.ui.activity.LoginActivity
import com.oceaning.user.ui.activity.RegisterActivity
import com.oceaning.user.ui.activity.ResetPwdActivity
import dagger.Component

/**
 * Created by ankeranker on 2018/8/12.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun injects(activity:RegisterActivity)
    fun injects(activity:LoginActivity)
    fun injects(activity:ForgetPwdActivity)
    fun injects(activity:ResetPwdActivity)
}