package com.oceaning.dianshan.ui.activity

import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.oceaning.baselibrary.ui.activity.BaseMVPActivity
import com.oceaning.dianshan.Presenter.MainPresenter
import com.oceaning.dianshan.Presenter.view.MainView
import com.oceaning.dianshan.R
import com.oceaning.dianshan.ui.fragment.HomeFragment
import com.oceaning.dianshan.ui.fragment.MeFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : BaseMVPActivity<MainPresenter>(),MainView {

    private var mFagStack=Stack<Fragment>()

    private val mHomeFragment by lazy { HomeFragment() }
    private val mCategoryFragment by lazy { HomeFragment() }
    private val mCarFragment by lazy { HomeFragment() }
    private val mMsgFragment by lazy { HomeFragment() }
    private val mMeFragment by lazy { MeFragment() }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initOperator() {
        super.initOperator()
        //mPresenter.mView = this
        mBottonNavBar.isHaveMsg(false)
        mBottonNavBar.setTextBadgeSize(0)
        initFragment()
        initBottomNav()
        changeFragment(0)
    }

    private fun initBottomNav() {
        mBottonNavBar.setTabSelectedListener(object :BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }

        })
    }

    private fun changeFragment(position: Int) {
        var fragmentManager=supportFragmentManager.beginTransaction()
        mFagStack.forEach {
            fragmentManager.hide(it)
        }
        fragmentManager.show(mFagStack[position])
        fragmentManager.commit()
    }

    private fun initFragment() {
        var fragmentManager=supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.mContaier,mHomeFragment)
        fragmentManager.add(R.id.mContaier,mCategoryFragment)
        fragmentManager.add(R.id.mContaier,mCarFragment)
        fragmentManager.add(R.id.mContaier,mMsgFragment)
        fragmentManager.add(R.id.mContaier,mMeFragment)
        fragmentManager.commit()

        mFagStack.add(mHomeFragment)
        mFagStack.add(mCategoryFragment)
        mFagStack.add(mCarFragment)
        mFagStack.add(mMsgFragment)
        mFagStack.add(mMeFragment)


    }


}
