package com.oceaning.user.presenter

import com.oceaning.baselibrary.net.DianShanRequest
import com.oceaning.baselibrary.net.ID_LOGIN
import com.oceaning.baselibrary.presenter.BasePresenter
import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import com.oceaning.user.bean.UserInfo
import com.oceaning.user.model.impl.UserServerImpl
import com.oceaning.user.net.api.UserApi
import com.oceaning.user.net.protocol.request.LoginRequest
import com.oceaning.user.net.protocol.request.RegisterRequest
import com.oceaning.user.presenter.view.LoginView
import com.oceaning.user.presenter.view.RegisterView
import javax.inject.Inject

/**
 * Created by ankeranker on 2018/7/29.
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {
    @Inject
    lateinit var usrServer: UserServerImpl

    fun login(mobile: String, pwd: String, pushId: String, listener: OnResponseListener) {
        if (isNetWorkAvailable()) {
            DianShanRequest.request(lifecycleProvider,
                    DianShanRequest.create(UserApi::class.java).login(LoginRequest(mobile, pwd, pushId))
                    , ID_LOGIN, listener)
        }
    }

    fun saveUserInfoToSP(userInfo: UserInfo) {
        usrServer.saveUserInfoToSP(userInfo)
    }


}