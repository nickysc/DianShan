package com.oceaning.user.ui.activity

import android.view.View
import com.oceaning.baselibrary.common.ext.isEnable
import com.oceaning.baselibrary.net.ID_LOGIN
import com.oceaning.baselibrary.ui.activity.BaseMVPActivity
import com.oceaning.user.R
import com.oceaning.user.injection.component.DaggerUserComponent
import com.oceaning.user.injection.module.UserModule
import com.oceaning.user.net.protocol.response.LoginResponse
import com.oceaning.user.presenter.LoginPresenter
import com.oceaning.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : BaseMVPActivity<LoginPresenter>(), LoginView {


    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initOperator() {
        super.initOperator()
        initInjection()
        mPresenter.mView = this
        initView()
        mLoginBtn.setOnClickListener(this)
        mHeaderBar.getRightTv().setOnClickListener(this)
        mForgetPwdTv.setOnClickListener(this)

    }

    private fun initView() {
        mLoginBtn.isEnable(mMobileEt, { isBtnEnable() })
        mLoginBtn.isEnable(mPwdEt, { isBtnEnable() })


    }

    private fun initInjection() {

        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().injects(this)
    }



    override fun onClick(v: View?) {
        super.onClick(v)
        when (v?.id) {
            R.id.mLoginBtn -> {
                mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"",this)
            }
            R.id.mRightTv->{
                startActivity<RegisterActivity>()
            }
            R.id.mForgetPwdTv->{
                startActivity<ForgetPwdActivity>()
            }
        }

    }

    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNotEmpty() &&
                mPwdEt.text.isNotEmpty()
    }

    override fun <T> onSuccess(t: T, id: Int) {
        super.onSuccess(t, id)
        when(id){
            ID_LOGIN->{
                t as LoginResponse
                mPresenter.saveUserInfoToSP(t.userInfo)
            }
        }
    }

    override fun onAfter(result: Boolean, id: Int) {
        super.onAfter(result, id)
        if(result){
            when(id){
                ID_LOGIN->{
                    startActivity<UserInfoActivity>()
                }
            }
        }
    }


}