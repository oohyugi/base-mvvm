package com.yogiputra.basemvvm.data

import com.yogiputra.basemvvm.core.model.BaseMdl
import com.yogiputra.basemvvm.core.model.LoginMdl
import com.yogiputra.basemvvm.core.model.RequestLoginMdl
import com.yogiputra.basemvvm.data.repository.LoginRepository
import com.yogiputra.basemvvm.data.source.remote.RemoteLoginDataSource
import com.yogiputra.basemvvm.data.utils.ResultState
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response

/**
 * Created by oohyugi on 2019-09-19.
 */
class LoginRepositoryUnitTest {


    private var loginDataSource = mock(RemoteLoginDataSource::class.java)
    private lateinit var loginRepo: LoginRepository

    private val loginResponse = BaseMdl(
        true,
        200,
        "",
        LoginMdl(
            "",
            "",
            ""
        )

    )
    private val loginRequest = RequestLoginMdl()


    @Before
    fun setup() {
        loginRepo = LoginRepository.LoginRepositoryImpl(loginDataSource)

    }

    @Test
    fun `should login success`() {
        val expected = ResultState.Success(loginResponse)

        val result = runBlocking {
            `when`(loginDataSource.postLogin(loginRequest))
                .thenReturn(Response.success(loginResponse))

            loginRepo.postLogin(loginRequest)
        }
        assertEquals(expected, result)


    }

    @Test
    fun `should return error`() {
        val actual = ResultState.Error("")
        val result = runBlocking {
            `when`(loginDataSource.postLogin(loginRequest))
                .thenReturn(
                    Response.error(
                        401,
                        ResponseBody.create(MediaType.parse("application/json"), "")
                    )
                )
            loginRepo.postLogin(loginRequest)
        }

        // probably has different error message, so you can check by type of java class
        assert(result.javaClass === actual.javaClass)
    }


}
