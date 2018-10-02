package com.oceaning.baselibrary.utils

import android.support.v4.app.FragmentManager
import com.oceaning.baselibrary.dialog.LoadingDialogFragment

/**
 * Created by ankeranker on 2018/9/2.
 */
fun showLoadingDialogFragment(fragmentManager: FragmentManager):LoadingDialogFragment{
    var fragment=LoadingDialogFragment()
    fragment.show(fragmentManager,"loading")
    return fragment
}