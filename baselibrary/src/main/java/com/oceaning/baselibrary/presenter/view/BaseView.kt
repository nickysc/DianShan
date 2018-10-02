package com.oceaning.baselibrary.presenter.view

/**
 * Created by ankeranker on 2018/7/29.
 */
interface BaseView {

    fun loadend()
    fun loading()
    fun onError(message:String)
}