package com.yogiputra.basemvvm.core.model

import com.google.gson.annotations.SerializedName


data class RequestLoginMdl(
    val email: String? = null,
    var password: String? = null
)

data class LoginMdl(
    @SerializedName("refresh_expired_at")
    val refreshExpiredAt: String = "",
    @SerializedName("expired_at")
    val expiredAt: String = "",
    @SerializedName("user")
    val user: String = "",
    @SerializedName("token")
    val token: String = ""
)