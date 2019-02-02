package com.eihror.todoappnavigationexample.extensions

import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.toolbar.*

fun Fragment.toolbar(s: String, b: Boolean, l: () -> Unit) {

    var title = toolbar_title
    var btn = toolbar_button

    title.text = s
    btn.visibility = if (b) View.VISIBLE else View.GONE

    if (b) {
        btn.setOnClickListener {
            l()
        }
    }

}