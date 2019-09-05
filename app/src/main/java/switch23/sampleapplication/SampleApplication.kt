package switch23.sampleapplication

import android.app.Application
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import switch23.sampleapplication.data.common.HttpClient
import switch23.sampleapplication.data.network.HogeApi
import switch23.sampleapplication.domain.repository.RemoteHogeRepository
import switch23.sampleapplication.domain.repository.RemoteHogeRepositoryImpl

class SampleApplication : Application() {
    private val hogeApi: HogeApi by lazy {
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(HttpClient.httpClient)
            .build()
            .create(HogeApi::class.java)
    }

    val hogeRepository: RemoteHogeRepository by lazy {
        RemoteHogeRepositoryImpl(hogeApi)
    }
}
