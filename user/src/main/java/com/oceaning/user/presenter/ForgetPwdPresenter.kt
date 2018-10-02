package com.oceaning.user.presenter

import com.oceaning.baselibrary.net.DianShanRequest
import com.oceaning.baselibrary.net.ID_FORGET_POSSWORD
import com.oceaning.baselibrary.net.ID_REGISTER
import com.oceaning.baselibrary.presenter.BasePresenter
import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import com.oceaning.user.model.impl.UserServerImpl
import com.oceaning.user.net.api.UserApi
import com.oceaning.user.net.protocol.request.ForgetPwdRequest
import com.oceaning.user.net.protocol.request.RegisterRequest
import com.oceaning.user.presenter.view.ForgetPwdView
import com.oceaning.user.presenter.view.RegisterView
import javax.inject.Inject

/**
 * Created by ankeranker on 2018/7/29.
 */
class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {
    @Inject
    lateinit var usrServer : UserServerImpl

    fun forgetPwd(mobile:String,verifyCode:String,listener: OnResponseListener){
        if (isNetWorkAvailable())
        {
            DianShanRequest.request(lifecycleProvider,
                    DianShanRequest.create(UserApi::class.java).forgetPwd(ForgetPwdRequest(mobile, verifyCode))
                    , ID_FORGET_POSSWORD,listener)
        }else{

        }
    }


}