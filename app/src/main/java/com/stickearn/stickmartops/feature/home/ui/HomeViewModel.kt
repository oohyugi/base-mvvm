package com.stickearn.stickmartops.feature.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stickearn.stickmartops.core.base.BaseViewState
import com.stickearn.stickmartops.core.model.MartboxMdl
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.repository.HomeRepository
import com.stickearn.stickmartops.data.utils.ResultState
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
    private val dispatcher: AppDispatchers
) : ViewModel() {
    // TODO: Implement the ViewModel

    private val _mMartboxListResult = MutableLiveData<BaseViewState<List<MartboxMdl>>>()

    val mMbarboxList: LiveData<BaseViewState<List<MartboxMdl>>> = _mMartboxListResult

    init {
        loadMartBox()
    }

    private fun loadMartBox() {
        _mMartboxListResult.value = BaseViewState.Loading
        viewModelScope.launch {
            val request = withContext(dispatcher.io) {
                repository.fetchHome()
            }
            when (request) {
                is ResultState.Success -> _mMartboxListResult.value =
                    BaseViewState.Success(request.data)
                is ResultState.Error -> _mMartboxListResult.value =
                    BaseViewState.Error(request.errorMessage)
            }
        }
    }

}
