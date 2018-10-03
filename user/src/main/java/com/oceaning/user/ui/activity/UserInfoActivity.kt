package com.oceaning.user.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import com.bigkoo.alertview.AlertView
import com.bigkoo.alertview.OnItemClickListener
import com.jph.takephoto.app.TakePhoto
import com.jph.takephoto.app.TakePhotoImpl
import com.jph.takephoto.compress.CompressConfig
import com.jph.takephoto.model.TResult
import com.kotlin.base.utils.DateUtils
import com.kotlin.base.utils.GlideUtils
import com.oceaning.baselibrary.ui.activity.BaseMVPActivity
import com.oceaning.user.R
import com.oceaning.user.injection.component.DaggerUserComponent
import com.oceaning.user.injection.module.UserModule
import com.oceaning.user.presenter.UserInfoPresenter
import com.oceaning.user.presenter.view.UserInfoView
import kotlinx.android.synthetic.main.activity_user_info.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import java.io.File
import com.jph.takephoto.permission.PermissionManager
import com.jph.takephoto.permission.PermissionManager.TPermissionType
import com.jph.takephoto.model.TContextWrap
import com.jph.takephoto.model.InvokeParam
import com.jph.takephoto.permission.InvokeListener
import com.jph.takephoto.permission.TakePhotoInvocationHandler







class UserInfoActivity : BaseMVPActivity<UserInfoPresenter>(), UserInfoView ,TakePhoto.TakeResultListener, InvokeListener {


    private lateinit var mTempFile:File

    private lateinit var mTakePhoto:TakePhoto




    override fun getLayoutId(): Int {
        return R.layout.activity_user_info
    }

    override fun onCreateBefore(savedInstanceState: Bundle?) {
        super.onCreateBefore(savedInstanceState)
        mTakePhoto= TakePhotoInvocationHandler.of(this).bind(TakePhotoImpl(this, this)) as TakePhoto
        mTakePhoto.onCreate(savedInstanceState)
    }

    override fun initOperator() {
        super.initOperator()
        initInjection()
        mPresenter.mView = this
        initView()

    }

    private fun initView() {
        mUserIconIv.setOnClickListener(this)

    }

    private fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().injects(this)
    }


    override fun onClick(v: View?) {
        super.onClick(v)
        when(v?.id){
            R.id.mUserIconIv->{
                showAlertView()
            }
        }
    }

    private fun showAlertView() {
        AlertView("选择图片","","取消",null, arrayOf("拍照","相册"),this,AlertView.Style.ActionSheet,
                OnItemClickListener { o, position ->
                    //开启压缩图片
                    mTakePhoto.onEnableCompress(CompressConfig.ofDefaultConfig(),false)
                    when(position){
                        0->{
                            createPictureFile()
                            mTakePhoto.onPickFromCapture(Uri.fromFile(mTempFile))
                        }
                        1->{
                            mTakePhoto.onPickFromGallery()
                        }
                    }
                }).show()
    }

    /**
     * 创建图片存放位置
     */
    private fun createPictureFile() {
        var fileName="${DateUtils.curTime}.png"
        if(Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()){
            mTempFile=File(Environment.getExternalStorageDirectory(),fileName)
            return
        }
        mTempFile= File(filesDir,fileName)

    }

    private var invokeParam: InvokeParam?=null

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //以下代码为处理Android6.0、7.0动态权限所需
        val type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this)
    }

    override fun invoke(invokeParam: InvokeParam?): TPermissionType {
        val type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam!!.method)
        if (TPermissionType.WAIT == type) {
            this.invokeParam = invokeParam
        }
        return type
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mTakePhoto.onActivityResult(requestCode,resultCode,data)

    }


    override fun takeCancel() {

    }

    override fun takeFail(result: TResult?, msg: String?) {
    }

    override fun takeSuccess(result: TResult?) {
        AnkoLogger("takePhoto").error("${result?.image?.compressPath}")
        AnkoLogger("takePhoto").error("${result?.image?.originalPath}")
        GlideUtils.loadImage(this,result?.image?.compressPath!!,mUserIconIv)


    }

    override fun onDestroy() {
        super.onDestroy()
    }

}