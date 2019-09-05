package switch23.sampleapplication.presentation.samplelist

import android.content.Context
import switch23.sampleapplication.domain.model.HogeModel
import switch23.sampleapplication.domain.usecase.SampleListUseCase
import switch23.sampleapplication.util.Exceptions
import switch23.sampleapplication.util.bindLaunch
import switch23.sampleapplication.util.sampleApplication
import java.lang.Exception
import java.util.concurrent.CancellationException

class SampleListPresenter(
    private var view: SampleListView?,
    private var context: Context,
    private val useCase: SampleListUseCase =
        SampleListUseCase(
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
            result?.let(nonNullView::showHogeList)
        }
    }

    fun onSampleItemClicked(hogeModel: HogeModel) {
        view?.openSampleHomePage(hogeModel)
    }
}
