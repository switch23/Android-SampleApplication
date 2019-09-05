package switch23.sampleapplication.util

import android.content.Context
import androidx.annotation.StringRes
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import retrofit2.HttpException
import switch23.sampleapplication.R
import switch23.sampleapplication.domain.model.ExceptionModel
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

sealed class Exceptions {

    abstract fun getMessage(context: Context): String

    data class ApiErrorFeedback(val message: String, val code: Int) : Exceptions() {
        override fun getMessage(context: Context): String = message
    }

    data class ApplicationErrorFeedback(@StringRes val resId: Int) : Exceptions() {
        override fun getMessage(context: Context): String = context.getString(resId)
    }

    companion object {
        fun map(throwable: Throwable): Exceptions = when (throwable) {
            is UnknownHostException ->
                ApplicationErrorFeedback(R.string.error_unknown_host)
            is ConnectException ->
                ApplicationErrorFeedback(R.string.error_connection)
            is SocketTimeoutException ->
                ApplicationErrorFeedback(R.string.error_socket_time_out)
            is HttpException -> {
                try {
                    throwable.response()?.errorBody()?.let {
                        ApiErrorFeedback(
                            Gson().fromJson(it.string(), ExceptionModel::class.java).message,
                            throwable.code()
                        )
                    } ?: throw JsonSyntaxException(Throwable())
                } catch (e: JsonSyntaxException) {
                    when (throwable.code()) {
                        404 -> ApplicationErrorFeedback(R.string.error_not_found)
                        406 -> ApplicationErrorFeedback(R.string.error_not_acceptable)
                        408 -> ApplicationErrorFeedback(R.string.error_request_time_out)
                        409 -> ApplicationErrorFeedback(R.string.error_conflict)
                        else -> ApplicationErrorFeedback(R.string.error_transmission)
                    }
                }
            }
            else -> ApplicationErrorFeedback(R.string.error_transmission)
        }
    }
}
