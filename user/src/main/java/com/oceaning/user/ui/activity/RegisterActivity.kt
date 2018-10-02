package com.oceaning.user.ui.activity


import android.view.View
import com.kotlin.base.widgets.VerifyButton
import com.oceaning.baselibrary.app.AppManager
import com.oceaning.baselibrary.common.ext.isEnable
import com.oceaning.baselibrary.net.ID_REGISTER
import com.oceaning.baselibrary.net.model.response.BaseResponse
import com.oceaning.baselibrary.ui.activity.BaseMVPActivity
import com.oceaning.baseretrofitandrx.retrofit.OnResponseListener
import com.oceaning.user.R
import com.oceaning.user.injection.component.DaggerUserComponent
import com.oceaning.user.injection.module.UserModule
import com.oceaning.user.presenter.RegisterPresenter
import com.oceaning.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMVPActivity<RegisterPresenter>(), RegisterView {


    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initOperator() {
        super.initOperator()
        initInjection()
        mPresenter.mView = this
        initView()
        mRegisterBtn.setOnClickListener(this)
        mVerifyCodeBtn.setOnClickListener(this)
    }

    private fun initView() {
        mRegisterBtn.isEnable(mMobileEt,{isBtnEnable()})
        mRegisterBtn.isEnable(mPwdConfirmEt,{isBtnEnable()})
        mRegisterBtn.isEnable(mPwdEt,{isBtnEnable()})
        mRegisterBtn.isEnable(mVerifyCodeEt,{isBtnEnable()})
    }

    private fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().injects(this)
    }


//    private var pressTime = 0.toLong()

//    override fun onBackPressed() {
//        var currentTime = System.currentTimeMillis()
//        if (currentTime - pressTime > 2000) {
//            toast("在按一次退出")
//            pressTime = currentTime
//        } else {
//            AppManager.exitApp(this)
//        }
//
//    }

    override fun onAfter(result: Boolean, id: Int) {
        super.onAfter(result, id)
        if (result){
            when(id){
                ID_REGISTER->{
                    startActivity<LoginActivity>()
                }
            }
        }
    }

    override fun <T> onSuccess(t: T, id: Int) {
        super.onSuccess(t, id)
        when(id){
            ID_REGISTER->{
                t as BaseResponse
                toast(t.message)
            }
        }
    }



    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.mRegisterBtn -> {
                mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString(), mVerifyCodeEt.text.toString(), this)
            }
            R.id.mVerifyCodeBtn -> {
                AnkoLogger("register").error("click")
                mVerifyCodeBtn.requestSendVerifyNumber()
            }
        }

    }

    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNotEmpty() &&
                mPwdEt.text.isNotEmpty() &&
                mPwdConfirmEt.text.isNotEmpty() &&
                mVerifyCodeEt.text.isNotEmpty()
    }

    override fun onDestroy() {
        super.onDestroy()
        mVerifyCodeBtn.removeRunable()
    }

}
