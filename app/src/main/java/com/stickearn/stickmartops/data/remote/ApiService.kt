package com.stickearn.stickmartops.data.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stickearn.stickmartops.BuildConfig
import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.ExampleMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.concurrent.TimeUnit

/**
 * Created by oohyugi on 2019-09-18.
 */

interface ApiService {

    @GET("/home")
    suspend fun getHome(): Response<BaseMdl<List<ExampleMdl>>>

    @POST("api/v1/auth")
    suspend fun postLogin(@Body payload: RequestLoginMdl): Response<BaseMdl<ResponseLoginMdl>>


    companion object {
        fun retrofitClient(url: String = BuildConfig.BASE_URL): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build()
        }

        private fun okHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(createLoggingInterceptor())
                .pingInterval(30, TimeUnit.SECONDS)
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build()
        }

        private fun createLoggingInterceptor(): HttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return interceptor
        }
    }
}