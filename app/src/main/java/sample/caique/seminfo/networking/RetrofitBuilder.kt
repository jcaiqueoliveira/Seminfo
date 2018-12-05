package sample.caique.seminfo.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.serializationConverterFactory
import kotlinx.serialization.json.JSON
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

/**
 * https://square.github.io/retrofit/
 * https://github.com/square/okhttp
 * https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor
 */

object RetrofitBuilder {

    private val contentType = MediaType.get("application/json")

    operator fun invoke(url: String) =
        Retrofit.Builder()
            .client(client())
            .baseUrl(url)
            .addConverterFactory(serializationConverterFactory(contentType, JSON.nonstrict))
            .build()

    private fun client(): OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
}