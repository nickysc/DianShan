package com.oceaning.user.ui.activity

import android.content.Intent
import android.view.View
import com.oceaning.baselibrary.common.ext.isEnable
import com.oceaning.baselibrary.constant.PARAM_MOBILE
import com.oceaning.baselibrary.net.ID_RESET_PASSWORD
import com.oceaning.baselibrary.net.model.response.BaseResponse
import com.oceaning.baselibrary.ui.activity.BaseMVPActivity
import com.oceaning.user.R
import com.oceaning.user.injection.component.DaggerUserComponent
import com.oceaning.user.injection.module.UserModule
import com.oceaning.user.presenter.ResetPwdPresenter
import com.oceaning.user.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ResetPwdActivity : BaseMVPActivity<ResetPwdPresenter>(), ResetPwdView {

    private lateinit var mobile:String

    override fun getLayoutId(): Int {
        return R.layout.activity_reset_pwd
    }

    override fun getIntentData(intent: Intent?) {
        super.getIntentData(intent)
        intent?.getStringExtra(PARAM_MOBILE)?.let { mobile=it }
    }

    override fun initOperator() {
        super.initOperator()
        initInjection()
        mPresenter.mView = this
        initView()
        mConfirmBtn.setOnClickListener(this)
        mHeaderBar.getRightTv().setOnClickListener(this)

    }

    private fun initView() {

        mConfirmBtn.isEnable(mPwdEt, { isBtnEnable() })
        mConfirmBtn.isEnable(mPwdConfirmEt, { isBtnEnable() })
    }

    private fun initInjection() {

        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().injects(this)
    }



    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.mConfirmBtn ->{mPresenter.resetPwd(mobile,mPwdEt.text.toString(),mPwdConfirmEt.text.toString(),this)}

        }

    }
    private fun isBtnEnable(): Boolean {
        return mPwdEt.text.isNotEmpty() &&
                mPwdConfirmEt.text.isNotEmpty()
    }

    override fun onAfter(result: Boolean, id: Int) {
        super.onAfter(result, id)
        if(result){
            when(id){
                ID_RESET_PASSWORD ->{
                    startActivity<LoginActivity>()
                }
            }
        }
    }


    override fun <T> onSuccess(t: T, id: Int) {
        super.onSuccess(t, id)
        when(id){

            ID_RESET_PASSWORD ->{
                t as BaseResponse
                toast(t.message)
            }
        }
    }



}