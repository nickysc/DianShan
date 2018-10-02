package com.oceaning.baseretrofitandrx.rxjava

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.kotlin.bindToLifecycle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ankeranker on 2018/8/10.
 */
fun <T> Observable<T>.execute(lifecycleProvider:LifecycleProvider<*>,observer: Observer<T>){
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .bindToLifecycle(lifecycleProvider)
            .subscribe(observer)
}