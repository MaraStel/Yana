package com.marstel.yana.network
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://world.openfoodfacts.org"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface YanaApiService {
    @GET("api/v3/product/737628064502.json")
    suspend fun getPhotos(): String
}

object YanaApi {
    val retrofitService : YanaApiService by lazy {
        retrofit.create(YanaApiService::class.java)
    }
}

