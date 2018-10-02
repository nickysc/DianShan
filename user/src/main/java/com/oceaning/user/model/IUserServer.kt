package com.oceaning.user.model

import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import com.oceaning.user.bean.UserInfo
import io.reactivex.Observable

/**
 * Created by ankeranker on 2018/8/4.
 */
interface IUserServer {
    fun saveUserInfoToSP(userInfo: UserInfo)
}