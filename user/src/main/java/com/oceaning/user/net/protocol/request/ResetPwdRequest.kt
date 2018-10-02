package com.oceaning.user.net.protocol.request

/**
 * Created by ankeranker on 2018/8/5.
 */
data class ResetPwdRequest(var mobile:String,var oldPassword:String, var newPassword:String)