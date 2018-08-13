package by.overpass.soraac.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://launchlibrary.net/1.4/"

val httpLoggingInterceptor by lazy {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    return@lazy interceptor
}

val okHttpClient by lazy {
    val clientBuilder = OkHttpClient.Builder()
    clientBuilder.interceptors().add(httpLoggingInterceptor)
    return@lazy clientBuilder.build()
}

val retrofit =
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.client(okHttpClient)
                .build()