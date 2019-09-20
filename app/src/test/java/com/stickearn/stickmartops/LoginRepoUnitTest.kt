package com.stickearn.stickmartops

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import com.stickearn.stickmartops.data.remote.ApiService
import com.stickearn.stickmartops.data.repository.login.LoginRepository
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
class LoginRepoUnitTest {


    private var mApiService = mock(ApiService::class.java)
    private lateinit var repository: LoginRepository

    private val loginResponse = BaseMdl(
        true,
        200,
        "",
        ResponseLoginMdl(
            "",
            "",
            ""
        )

    )
    private val loginRequest = RequestLoginMdl("admin@stickmart.store", "Stickmart2018")


    @Before
    fun setup() {
        repository = LoginRepository.LoginRepositoryImpl(mApiService)

    }

    @Test
    fun `should login success`() = runBlocking {
        `when`(mApiService.postLogin(loginRequest)).thenReturn(
            Response.success(loginResponse)
        )

        val repo = repository.postLogin(loginRequest)
        assertEquals(repo.body(), loginResponse)
    }

    @Test
    fun `should get error`() = runBlocking {
        `when`(mApiService.postLogin(loginRequest)).thenReturn(
            Response.error(401, ResponseBody.create(MediaType.parse("application/json"), ""))
        )

        val repo = repository.postLogin(loginRequest)
        assertEquals(repo.body(), null)
    }


}
