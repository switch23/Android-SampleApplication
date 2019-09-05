package switch23.sampleapplication.presentation.samplegrid

import switch23.sampleapplication.domain.model.HogeModel
import switch23.sampleapplication.util.LifecycleScopeSupport

interface SampleGridView : LifecycleScopeSupport {
    fun showHogeGrid(hogeList: List<HogeModel>)
    fun showToast(message: String)
    fun openSampleHomePage(hogeModel: HogeModel)
}
