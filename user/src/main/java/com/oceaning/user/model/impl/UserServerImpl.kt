package com.oceaning.user.model.impl

import com.kotlin.base.utils.*
import com.oceaning.baselibrary.net.DianShanRequest
import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import com.oceaning.user.bean.UserInfo
import com.oceaning.user.model.IUserServer
import com.oceaning.user.net.api.UserApi
import com.oceaning.user.net.protocol.request.RegisterRequest
import javax.inject.Inject

/**
 * Created by ankeranker on 2018/8/4.
 */
class UserServerImpl @Inject constructor() :IUserServer {
    override fun saveUserInfoToSP(userInfo: UserInfo) {
        userInfo.user_gender?.let { AppPrefsUtils.putString(SP_KEY_GENDER,it) }
        userInfo.user_icon?.let { AppPrefsUtils.putString(SP_KEY_GENDER,it) }
        userInfo.user_mobile?.let { AppPrefsUtils.putString(SP_KEY_GENDER,it) }
        userInfo.user_name?.let { AppPrefsUtils.putString(SP_KEY_GENDER,it) }

    }

}