package switch23.sampleapplication.data.network

import retrofit2.http.*
import switch23.sampleapplication.domain.model.HogeModel

interface HogeApi {
    @GET("hoges")
    suspend fun getHoges(): List<HogeModel>

    @Multipart
    @POST("hoges")
    suspend fun postHoge(
        @Part("id") id: Int,
        @Part("post_text") body: String
    ): HogeModel
}
