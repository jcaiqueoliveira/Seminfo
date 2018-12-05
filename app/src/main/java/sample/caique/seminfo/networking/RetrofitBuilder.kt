package sample.caique.seminfo.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.serializationConverterFactory
import kotlinx.serialization.json.JSON
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit


object RetrofitBuilder {

    private val contentType = MediaType.get("application/json")

    operator fun invoke(url: String) =
        Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(url)
            .addConverterFactory(serializationConverterFactory(contentType, JSON.nonstrict))
            .build()
}