package com.arpit.cessini_task_two.api

import com.arpit.cessini_task_two.model.SignInBody
import com.arpit.cessini_task_two.model.SignInResponseBody
import com.arpit.cessini_task_two.model.SignUpBody
import com.arpit.cessini_task_two.model.SignUpResponseBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

    @Headers("Content-Type:application/json")
    @POST("auth_tokens")
    fun signin(@Body info: SignInBody): Call<SignInResponseBody>


    @Headers("Content-Type:application/json")
    @POST("users")
    fun signUp(
        @Body info: SignUpBody
    ): Call<SignUpResponseBody>
}

class RetrofitInstance {
    companion object {
        val BASE_URL: String = "http://miworld.herokuapp.com/"

        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}