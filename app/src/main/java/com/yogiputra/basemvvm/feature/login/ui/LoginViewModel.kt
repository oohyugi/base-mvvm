package com.yogiputra.basemvvm.feature.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yogiputra.basemvvm.core.base.BaseViewModel
import com.yogiputra.basemvvm.core.base.BaseViewState
import com.yogiputra.basemvvm.core.model.LoginMdl
import com.yogiputra.basemvvm.core.model.RequestLoginMdl
import com.yogiputra.basemvvm.core.utils.AppDispatchers
import com.yogiputra.basemvvm.data.repository.LoginRepository
import com.yogiputra.basemvvm.data.utils.ResultState
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
    private val dispatcher: AppDispatchers
) : BaseViewModel() {


    private val _loginResult = MutableLiveData<BaseViewState<LoginMdl>>()

    val responseLogin: LiveData<BaseViewState<LoginMdl>> = _loginResult


    fun login(email: String?, password: String?) {
        _loginResult.value = BaseViewState.Loading
        viewModelScope.launch {
            val request = withContext(dispatcher.io) {
                repository.postLogin(RequestLoginMdl(email, password))
            }
            when (request) {
                is ResultState.Success -> _loginResult.value =
                    BaseViewState.Success(request.data?.data)
                is ResultState.Error -> _loginResult.value =
                    BaseViewState.Error(request.errorMessage)
            }
        }
    }

}