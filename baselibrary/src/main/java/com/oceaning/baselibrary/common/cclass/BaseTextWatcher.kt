package com.oceaning.baselibrary.common.cclass

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by ankeranker on 2018/9/2.
 */
abstract class BaseTextWatcher:TextWatcher{
    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

}