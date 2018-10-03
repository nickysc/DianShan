package com.oceaning.user.injection.component

import com.oceaning.baselibrary.injection.component.ActivityComponent
import com.oceaning.baselibrary.injection.scope.PerComponentScope
import com.oceaning.user.injection.module.UserModule
import com.oceaning.user.ui.activity.*
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
    fun injects(activity:UserInfoActivity)

}