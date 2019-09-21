package com.yogiputra.basemvvm.core.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.yogiputra.basemvvm.BuildConfig

/**
 * Created by oohyugi on 2019-09-18.
 */


fun Context.toast(message: String?) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

}

fun String.loge(tag: String) {
    if (BuildConfig.DEBUG) {
        Log.wtf(tag, this)
    }
}