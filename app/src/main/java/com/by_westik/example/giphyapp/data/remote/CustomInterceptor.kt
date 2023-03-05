package com.by_westik.example.giphyapp.data.remote

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", "dK7Skxg1j3Efjo6KR9JCo3yE8ZGgU6C4").build()
        request.url(url)

        return chain.proceed(request.build())
    }

}