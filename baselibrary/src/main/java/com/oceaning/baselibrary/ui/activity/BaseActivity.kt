package com.oceaning.baselibrary.ui.activity

import android.content.Intent
import android.os.Bundle
import com.oceaning.baselibrary.app.AppManager
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by ankeranker on 2018/7/29.
 */
abstract class BaseActivity :RxAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        AppManager.addActivity(this)
        getIntentData(intent)
        initOperator()


    }

    open fun getIntentData(intent: Intent?) {

    }

    abstract fun initOperator()

    abstract fun getLayoutId(): Int


    override fun onDestroy() {
        super.onDestroy()
        AppManager.removeActivity(this)
    }
}