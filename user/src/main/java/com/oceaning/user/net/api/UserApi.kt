package com.oceaning.user.net.api

import com.oceaning.baselibrary.net.model.response.BaseResponse
import com.oceaning.user.net.protocol.request.ForgetPwdRequest
import com.oceaning.user.net.protocol.request.LoginRequest
import com.oceaning.user.net.protocol.request.RegisterRequest
import com.oceaning.user.net.protocol.request.ResetPwdRequest
import com.oceaning.user.net.protocol.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

/**
 * Created by ankeranker on 2018/8/5.
 */
interface UserApi {
    @POST("user/register")
    fun register(@Body registerRequest: RegisterRequest):Observable<BaseResponse>
    @POST("user/login")
    fun login(@Body loginRequest: LoginRequest):Observable<LoginResponse>

    @POST("user/forgetpwd")
    fun forgetPwd(@Body forgetPwdRequest: ForgetPwdRequest):Observable<BaseResponse>
    @POST("user/resetpwd")
    fun resetPwd(@Body resetPwdRequest: ResetPwdRequest):Observable<BaseResponse>
}