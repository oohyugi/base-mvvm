package com.stickearn.stickmartops.core.helper

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-19.
 */

class PrefHelper @Inject
constructor(private val context: Context) {

    companion object {
        const val PREF_USER_LOGIN = "pref_user_login"
    }


    private fun pref(): SharedPreferences {
        return context.getSharedPreferences("PrefStickmartOps", Context.MODE_PRIVATE)
    }

    fun saveUserLogin(data: ResponseLoginMdl?) {
        data?.apply {
            pref().edit().putString(PREF_USER_LOGIN, Gson().toJson(this)).apply()
        }

    }

    fun getUserLogin(): ResponseLoginMdl? {
        val json = pref().getString(PREF_USER_LOGIN, null)
        var user: ResponseLoginMdl? = null
        json?.apply {
            user = Gson().fromJson<ResponseLoginMdl>(json, ResponseLoginMdl::class.java)
        }

        return user
    }

}
