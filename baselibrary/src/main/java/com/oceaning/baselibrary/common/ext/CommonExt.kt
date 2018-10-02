package com.oceaning.baselibrary.common.ext

import android.widget.Button
import android.widget.EditText
import com.oceaning.baselibrary.common.cclass.BaseTextWatcher

/**
 * Created by ankeranker on 2018/9/2.
 */
fun Button.isEnable(editText: EditText,method:()->Boolean){
    var button=this
    editText.addTextChangedListener(object :BaseTextWatcher(){
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            super.onTextChanged(s, start, before, count)
            button.isEnabled = method()
        }
    })

}