package com.stickearn.stickmartops.data

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.LoginMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.data.repository.LoginRepository
import com.stickearn.stickmartops.data.source.remote.RemoteLoginDataSource
import com.stickearn.stickmartops.data.utils.ResultState
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
    private val loginRequest = RequestLoginMdl("admin@stickmart.store", "Stickmart2018")


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
