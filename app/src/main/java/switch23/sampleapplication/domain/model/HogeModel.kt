package switch23.sampleapplication.domain.model

import com.google.gson.annotations.SerializedName

data class HogeModel(
    @SerializedName("hoge_id")
    val id: Int,
    @SerializedName("hoge_url")
    val url: String,
    @SerializedName("hoge_title")
    val title: String,
    @SerializedName("hoge_body")
    val body: String,
    @SerializedName("hoge_image_url")
    val imageUrl: String
)
