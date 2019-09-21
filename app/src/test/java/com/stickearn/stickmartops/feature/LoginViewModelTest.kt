package com.stickearn.stickmartops.feature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.stickearn.stickmartops.core.base.BaseViewState
import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.LoginMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.repository.LoginRepository
import com.stickearn.stickmartops.data.utils.ResultState
import com.stickearn.stickmartops.feature.login.ui.LoginViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by oohyugi on 2019-09-07.
 * github: https://github.com/oohyugi
 */
@ExperimentalCoroutinesApi
class LoginViewModelTest {
    @get: Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var result: Observer<BaseViewState<LoginMdl>>
    @Mock
    lateinit var loginRepo: LoginRepository


    private lateinit var viewModel: LoginViewModel
    private val appDispatchers = AppDispatchers(Dispatchers.IO, Dispatchers.Main)

    private val loginResponse =
        LoginMdl(
            "",
            "",
            ""
        )

    private val baseResponse = BaseMdl(
        true,
        200,
        "",
        loginResponse

    )

    private val loginRequest = RequestLoginMdl("admin@stickmart.store", "Stickmart2018")


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(appDispatchers.main)
        viewModel = LoginViewModel(loginRepo, appDispatchers)
        viewModel.responseLogin.observeForever(result)
    }

    @Test
    fun `should login success`() = runBlocking {
        `when`(loginRepo.postLogin(loginRequest))
            .thenReturn(ResultState.Success(baseResponse))


        //when
        viewModel.login(loginRequest.email, loginRequest.password)


        //then
        verify(result).onChanged(BaseViewState.Loading)
        verify(result).onChanged(BaseViewState.Success(baseResponse.data))
        clearInvocations(loginRepo, result)
    }

    @Test
    fun `should login error`() = runBlocking {

        val error = "error"
        `when`(loginRepo.postLogin(loginRequest))
            .thenReturn(ResultState.Error(error))


        //when
        viewModel.login(loginRequest.email, loginRequest.password)


        //then
        verify(result).onChanged(BaseViewState.Loading)
        verify(result).onChanged(BaseViewState.Error(error))
        clearInvocations(loginRepo, result)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()

    }
}
