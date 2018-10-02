package com.oceaning.baseretrofitandrx.retrofit

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.oceaning.baseretrofitandrx.Config.HttpBuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ankeranker on 2018/8/10.
 */
abstract class BaseRequest {

    var retrofit:Retrofit?=null

    private fun createRetrofit(){
        retrofit= Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(initClient())
                .build()
    }

    abstract fun getBaseUrl(): String


    private fun initClient():OkHttpClient?{
        return OkHttpClient.Builder()
                .addInterceptor(initHeaderInterceptor())
                .addInterceptor(initLogInterceptor())
                .connectTimeout(HttpBuildConfig.CONNECT_TIME_OUT,HttpBuildConfig.TIME_UNIT)
                .readTimeout(HttpBuildConfig.READ_TIME_OUT,HttpBuildConfig.TIME_UNIT)
                .build()
    }

    private fun initHeaderInterceptor(): Interceptor? {

        return Interceptor {
            chain ->
            var requestBuilder=chain.request().newBuilder()
            getHeaders()?.forEach {
                requestBuilder.addHeader(it.key,it.value)
            }
            var request=requestBuilder.build()
            chain.proceed(request)
        }
    }

    abstract fun getHeaders():MutableMap<String,String>?

    private fun initLogInterceptor(): Interceptor? {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T>create(service:Class<T>):T{
        if (retrofit==null){
            createRetrofit()
        }
        return retrofit?.create(service)!!
    }
}