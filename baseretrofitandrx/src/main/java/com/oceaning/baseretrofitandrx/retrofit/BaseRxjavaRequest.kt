package com.oceaning.baseretrofitandrx.retrofit

import com.oceaning.baseretrofitandrx.rxjava.execute
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference
import android.accounts.NetworkErrorException
import com.trello.rxlifecycle2.LifecycleProvider
import java.net.ConnectException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException


/**
 * Created by ankeranker on 2018/8/11.
 */
abstract class BaseRxjavaRequest :BaseRequest() {

     var weakReference : WeakReference<OnResponseListener>?=null


    fun <T> request(lifecycleProvider: LifecycleProvider<*>,observable:Observable<T>, id:Int, listener: OnResponseListener){
        weakReference = WeakReference(listener)

       observable.execute(lifecycleProvider,object: Observer<T>{
           override fun onSubscribe(d: Disposable) {
                if (weakReference?.get()!=null){
                    weakReference?.get()?.onBefore(d,id)
                }
           }

           override fun onNext(t: T) {
               onResponse(t,id)
           }

           override fun onComplete() {
               if (weakReference?.get()!=null){
                   weakReference?.get()?.onAfter(true,id)
               }
           }

           override fun onError(e: Throwable) {
               try {
                   if (e is ConnectException
                           || e is TimeoutException
                           || e is NetworkErrorException
                           || e is UnknownHostException) {
                       if (weakReference?.get()!=null){
                           weakReference?.get()?.onFailure(e,true,id)
                       }
                   } else {
                       if (weakReference?.get()!=null){
                           weakReference?.get()?.onFailure(e,false,id)
                       }
                   }
               } catch (e1: Exception) {
                   e1.printStackTrace()
               }
               if (weakReference?.get()!=null){
                   weakReference?.get()?.onAfter(false,id)
               }
           }

       })
    }

    abstract fun<T> onResponse(t:T,id:Int)
}