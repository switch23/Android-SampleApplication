package switch23.sampleapplication.presentation.samplegrid

import android.content.Context
import switch23.sampleapplication.domain.model.HogeModel
import switch23.sampleapplication.domain.usecase.SampleGridUseCase
import switch23.sampleapplication.util.Exceptions
import switch23.sampleapplication.util.bindLaunch
import switch23.sampleapplication.util.sampleApplication
import java.lang.Exception
import java.util.concurrent.CancellationException

class SampleGridPresenter(
    private var view: SampleGridView?,
    private var context: Context,
    private val useCase: SampleGridUseCase =
        SampleGridUseCase(
            context.sampleApplication.hogeRepository
        )
) {

    fun onViewCreated() {
        showSampleList()
    }

    fun onDestroy() {
        view = null
    }

    fun onRefresh() {
        onViewCreated()
    }

    private fun showSampleList() {
        val nonNullView = view ?: return
        nonNullView.bindLaunch {
            val result = try {
                useCase.getHoges()
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                nonNullView.showToast(Exceptions.map(e).getMessage(context))
                null
            }
            result?.let(nonNullView::showHogeGrid)
        }
    }

    fun onSampleItemClicked(hogeModel: HogeModel) {
        view?.openSampleHomePage(hogeModel)
    }
}
