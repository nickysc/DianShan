package com.oceaning.user.presenter

import com.oceaning.baselibrary.net.DianShanRequest
import com.oceaning.baselibrary.net.ID_REGISTER
import com.oceaning.baselibrary.presenter.BasePresenter
import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import com.oceaning.user.model.impl.UserServerImpl
import com.oceaning.user.net.api.UserApi
import com.oceaning.user.net.protocol.request.RegisterRequest
import com.oceaning.user.presenter.view.RegisterView
import com.oceaning.user.presenter.view.UserInfoView
import javax.inject.Inject

/**
 * Created by ankeranker on 2018/7/29.
 */
class UserInfoPresenter @Inject constructor() : BasePresenter<UserInfoView>() {
    @Inject
    lateinit var usrServer : UserServerImpl



}