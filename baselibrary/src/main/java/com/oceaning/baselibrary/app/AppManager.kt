package com.oceaning.baselibrary.app

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * Created by ankeranker on 2018/8/23.
 */
object AppManager {

    private var activityStack:Stack<Activity> = Stack()

    fun addActivity(activity: Activity){
        activityStack.add(activity)
    }

    fun removeActivity(activity: Activity){
        activity.finish()
        activityStack.remove(activity)
    }

    fun currentActivity():Activity{
        return activityStack.lastElement()
    }

    fun finishAllActivity(){
        activityStack.forEach {
            it.finish()
        }
        activityStack.clear()
    }

    fun exitApp(context: Context){
        finishAllActivity()
        var activityManager=context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }
}