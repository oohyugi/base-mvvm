package com.stickearn.stickmartops.feature.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.stickearn.stickmartops.core.base.BaseViewModel
import com.stickearn.stickmartops.core.base.BaseViewState
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.utils.ResultState
import com.stickearn.stickmartops.feature.login.domain.LoginUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val useCase: LoginUseCase,
    private val dispatcher: AppDispatchers
) : BaseViewModel() {


    private val _loginResult = MutableLiveData<BaseViewState<ResponseLoginMdl>>()

    val responseLogin: LiveData<BaseViewState<ResponseLoginMdl>> = _loginResult


    fun login(email: String?, password: String?) {
        _loginResult.value = BaseViewState.ShowLoading
        viewModelScope.launch {
            val request = withContext(dispatcher.io) {
                useCase.postLogin(email, password)
            }
            when (request) {
                is ResultState.Success -> _loginResult.value =
                    BaseViewState.Success(request.data?.data)
                is ResultState.Error -> _loginResult.value =
                    BaseViewState.ShowError(request.errorMessage)
            }
        }
    }

}