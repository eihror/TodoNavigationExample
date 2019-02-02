package com.eihror.todoappnavigationexample.extensions

import android.view.View

fun View.enable(b: Boolean, applyAlpha: Boolean = true) {
    apply {
        isEnabled = b
        isClickable = b
    }

    if (applyAlpha) {
        alpha = if (b) {
            1f
        } else {
            0.3f
        }
    }
}