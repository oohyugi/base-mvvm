package com.stickearn.stickmartops.feature.login.domain

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import com.stickearn.stickmartops.data.repository.login.LoginRepository
import com.stickearn.stickmartops.data.utils.ResultState
import com.stickearn.stickmartops.data.utils.fetchState
import javax.inject.Inject


class LoginUseCase @Inject constructor(private val repository: LoginRepository) {

    suspend fun postLogin(
        email: String?,
        password: String?
    ): ResultState<BaseMdl<ResponseLoginMdl>> {
        return fetchState {
            val response = repository.postLogin(RequestLoginMdl(email, password))
            if (response.isSuccessful) {
                ResultState.Success(response.body())
            } else {
                ResultState.Error(response.message())
            }
        }
    }

}
