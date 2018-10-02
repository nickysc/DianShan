package com.oceaning.user.presenter

import com.oceaning.baselibrary.net.DianShanRequest
import com.oceaning.baselibrary.net.ID_REGISTER
import com.oceaning.baselibrary.net.ID_RESET_PASSWORD
import com.oceaning.baselibrary.presenter.BasePresenter
import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import com.oceaning.user.model.impl.UserServerImpl
import com.oceaning.user.net.api.UserApi
import com.oceaning.user.net.protocol.request.ForgetPwdRequest
import com.oceaning.user.net.protocol.request.ResetPwdRequest
import com.oceaning.user.presenter.view.ForgetPwdView
import com.oceaning.user.presenter.view.ResetPwdView
import javax.inject.Inject

/**
 * Created by ankeranker on 2018/7/29.
 */
class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {
    @Inject
    lateinit var usrServer : UserServerImpl

    fun resetPwd(mobile:String,oldPassword:String,newPassword:String,listener: OnResponseListener){
        if (isNetWorkAvailable())
        {
            DianShanRequest.request(lifecycleProvider,
                    DianShanRequest.create(UserApi::class.java).resetPwd(ResetPwdRequest(mobile,oldPassword, newPassword))
                    , ID_RESET_PASSWORD,listener)
        }else{

        }
    }


}