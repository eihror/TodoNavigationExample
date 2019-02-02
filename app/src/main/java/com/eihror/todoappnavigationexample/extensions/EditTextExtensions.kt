package com.eihror.todoappnavigationexample.extensions

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText

fun EditText.isFilled(): Boolean {
    return !TextUtils.isEmpty(text.toString())
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}