package switch23.sampleapplication.data.common

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object HttpClient {

    val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()
                // header
                val request = original.newBuilder()
                    .header("Accept", "application/json")
                    .method(original.method(), original.body())
                    .build()
                return@Interceptor chain.proceed(request)
            })
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }
}
