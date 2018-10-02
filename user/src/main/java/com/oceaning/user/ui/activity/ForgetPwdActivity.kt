package com.oceaning.user.ui.activity

import android.view.View
import com.oceaning.baselibrary.common.ext.isEnable
import com.oceaning.baselibrary.constant.PARAM_MOBILE
import com.oceaning.baselibrary.net.ID_FORGET_POSSWORD
import com.oceaning.baselibrary.net.model.response.BaseResponse
import com.oceaning.baselibrary.ui.activity.BaseMVPActivity
import com.oceaning.user.R
import com.oceaning.user.injection.component.DaggerUserComponent
import com.oceaning.user.injection.module.UserModule
import com.oceaning.user.presenter.ForgetPwdPresenter
import com.oceaning.user.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ForgetPwdActivity : BaseMVPActivity<ForgetPwdPresenter>(), ForgetPwdView {



    override fun getLayoutId(): Int {
        return R.layout.activity_forget_pwd
    }

    override fun initOperator() {
        super.initOperator()
        initInjection()
        mPresenter.mView = this
        initView()
        mNextBtn.setOnClickListener(this)
        mHeaderBar.getRightTv().setOnClickListener(this)

    }

    private fun initView() {

        mNextBtn.isEnable(mMobileEt, { isBtnEnable() })
        mNextBtn.isEnable(mVerifyCodeEt, { isBtnEnable() })
    }

    private fun initInjection() {

        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().injects(this)
    }



    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.mNextBtn->{mPresenter.forgetPwd(mMobileEt.text.toString(),mVerifyCodeEt.text.toString(),this)}
        }

    }
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNotEmpty() &&
                mVerifyCodeEt.text.isNotEmpty()
    }

    override fun onAfter(result: Boolean, id: Int) {
        super.onAfter(result, id)
        if(result){
            when(id){
                ID_FORGET_POSSWORD->{
                    startActivity<ResetPwdActivity>(PARAM_MOBILE to mMobileEt.text.toString())
                }
            }
        }
    }


    override fun <T> onSuccess(t: T, id: Int) {
        super.onSuccess(t, id)
        when(id){

            ID_FORGET_POSSWORD->{
                t as BaseResponse
                toast(t.message)
            }
        }
    }



}