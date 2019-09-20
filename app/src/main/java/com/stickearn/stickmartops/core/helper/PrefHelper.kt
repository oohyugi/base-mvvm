package com.stickearn.stickmartops.core.helper

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.stickearn.stickmartops.core.model.LoginMdl
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

    fun saveUserLogin(data: LoginMdl?) {
        data?.apply {
            pref().edit().putString(PREF_USER_LOGIN, Gson().toJson(this)).apply()
        }

    }

    fun getUserLogin(): LoginMdl? {
        val json = pref().getString(PREF_USER_LOGIN, null)
        var user: LoginMdl? = null
        json?.apply {
            user = Gson().fromJson<LoginMdl>(json, LoginMdl::class.java)
        }

        return user
    }

}
