package switch23.sampleapplication.domain.model

import com.google.gson.annotations.SerializedName

data class ExceptionModel(
    @SerializedName("message")
    val message: String
)
