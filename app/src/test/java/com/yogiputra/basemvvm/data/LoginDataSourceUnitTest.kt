package com.yogiputra.basemvvm.data

import com.yogiputra.basemvvm.core.model.BaseMdl
import com.yogiputra.basemvvm.core.model.LoginMdl
import com.yogiputra.basemvvm.core.model.RequestLoginMdl
import com.yogiputra.basemvvm.data.source.LoginDataSource
import com.yogiputra.basemvvm.data.source.remote.AuthService
import com.yogiputra.basemvvm.data.source.remote.RemoteLoginDataSource
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
class LoginDataSourceUnitTest {


    private var mApiService = mock(AuthService::class.java)
    private lateinit var loginDataSource: LoginDataSource

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
        loginDataSource = RemoteLoginDataSource(mApiService)

    }

    @Test
    fun `should login success`() = runBlocking {
        `when`(mApiService.postLogin(loginRequest)).thenReturn(
            Response.success(loginResponse)
        )

        val repo = loginDataSource.postLogin(loginRequest)

        assertEquals(loginResponse, repo.body())

    }

    @Test
    fun `should get error`() = runBlocking {
        `when`(mApiService.postLogin(loginRequest)).thenReturn(
            Response.error(401, ResponseBody.create(MediaType.parse("application/json"), ""))
        )

        val repo = loginDataSource.postLogin(loginRequest)
        assertEquals(repo.body(), null)
    }


}
