package com.example.side_project_puppy_mobile

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object TrailServiceImpl {
    private var service: TrailService? = null
    val _url = "Please inpt URL"
    fun getService(): TrailService{
        if (service == null){
            var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit: Retrofit =
                Retrofit.Builder().baseUrl(_url).client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(
                        GsonConverterFactory.create(
                            GsonBuilder().setLenient().create()
                        )
                    ).build()

        }
        return service!!
    }
}