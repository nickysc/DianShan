package com.oceaning.baseretrofitandrx.retrofit

import io.reactivex.disposables.Disposable

/**
 * Created by ankeranker on 2018/8/11.
 */
interface OnResponseListener {

    fun onBefore(d: Disposable,id:Int)
    fun onAfter(result:Boolean,id:Int)
    fun onFailure(e: Throwable,isNet:Boolean,id:Int)
    fun<T> onSuccess(t:T,id:Int)
    fun onCodeError(message:String,id:Int)
}