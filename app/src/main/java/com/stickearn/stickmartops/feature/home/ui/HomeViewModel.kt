package com.stickearn.stickmartops.feature.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stickearn.stickmartops.core.base.BaseViewState
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.core.utils.loge
import com.stickearn.stickmartops.data.utils.ResultState
import com.stickearn.stickmartops.feature.home.domain.HomeUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: HomeUseCase,
    private val dispatcher: AppDispatchers
) : ViewModel() {
    // TODO: Implement the ViewModel

    private val _exampleResult = MutableLiveData<BaseViewState<ResponseLoginMdl>>()

    val exampleResult: LiveData<BaseViewState<ResponseLoginMdl>> = _exampleResult


    fun loadExample(email: String?, password: String?) {
        email?.loge("masuk")
        _exampleResult.value = BaseViewState.ShowLoading
        viewModelScope.launch {
            val request = withContext(dispatcher.io) {
                useCase.postLogin(email, password)
            }
            when (request) {
                is ResultState.Success -> _exampleResult.value =
                    BaseViewState.Success(request.data?.data)
                is ResultState.Error -> _exampleResult.value =
                    BaseViewState.ShowError(request.errorMessage)
            }
        }
    }

}
