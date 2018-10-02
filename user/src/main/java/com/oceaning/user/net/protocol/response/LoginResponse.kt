package com.oceaning.user.net.protocol.response

import com.oceaning.baselibrary.net.model.response.BaseResponse
import com.oceaning.user.bean.UserInfo

/**
 * Created by ankeranker on 2018/9/3.
 */
class LoginResponse(status:Int,message:String,userInfo:UserInfo) :BaseResponse(status,message) {
    val userInfo=userInfo
}