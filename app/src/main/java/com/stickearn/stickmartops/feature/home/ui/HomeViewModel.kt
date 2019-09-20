package com.stickearn.stickmartops.feature.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stickearn.stickmartops.core.base.BaseViewState
import com.stickearn.stickmartops.core.model.ExampleMdl
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.source.repository.HomeRepository
import com.stickearn.stickmartops.data.utils.ResultState
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val dispatcher: AppDispatchers
) : ViewModel() {
    // TODO: Implement the ViewModel

    private val _exampleResult = MutableLiveData<BaseViewState<List<ExampleMdl>>>()

    val exampleResult: LiveData<BaseViewState<List<ExampleMdl>>> = _exampleResult

    init {
        loadExample()
    }

    fun loadExample() {
        _exampleResult.value = BaseViewState.ShowLoading
        viewModelScope.launch {
            val request = withContext(dispatcher.io) {
                repository.fetchHome()
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
