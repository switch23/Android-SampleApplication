package switch23.sampleapplication.presentation.samplelist

import switch23.sampleapplication.domain.model.HogeModel
import switch23.sampleapplication.util.LifecycleScopeSupport

interface SampleListView : LifecycleScopeSupport {
    fun showHogeList(hogeList: List<HogeModel>)
    fun showToast(message: String)
    fun openSampleHomePage(hogeModel: HogeModel)
}
