package com.oceaning.baselibrary.net

import com.oceaning.baselibrary.net.model.response.BaseResponse
import com.oceaning.baseretrofitandrx.retrofit.BaseRxjavaRequest
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * Created by ankeranker on 2018/8/11.
 */
object DianShanRequest : BaseRxjavaRequest() {
    override fun getBaseUrl(): String {
        return baseUrl
    }

    override fun getHeaders(): MutableMap<String, String>? {
        return null
    }

    override fun <T> onResponse(t: T, id: Int) {
        AnkoLogger("DianShanRequest").error("$t")
        if (t is BaseResponse)
        {
            if (t.status==1)
            {
                AnkoLogger("DianShanRequest").error("$t")
                if (weakReference?.get()!=null){
                    weakReference?.get()?.onSuccess(t,id)
                }
            }else{
                if (weakReference?.get()!=null){
                    weakReference?.get()?.onCodeError(t.message,id)
                }
            }

        }

    }
}