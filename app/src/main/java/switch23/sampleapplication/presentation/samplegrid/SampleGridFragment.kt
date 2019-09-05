package switch23.sampleapplication.presentation.samplegrid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import switch23.sampleapplication.R
import switch23.sampleapplication.databinding.FragmentSampleGridBinding
import switch23.sampleapplication.domain.model.HogeModel
import switch23.sampleapplication.util.LifecycleScope

class SampleGridFragment : Fragment(),
    SampleGridView,
    SwipeRefreshLayout.OnRefreshListener {

    private lateinit var binding: FragmentSampleGridBinding
    private lateinit var presenter: SampleGridPresenter
    override val scope = LifecycleScope(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SampleGridPresenter(this, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sample_grid,
            container,
            false
        )

        val hogeList = listOf<HogeModel>()
        binding.recyclerViewSampleGrid.setHasFixedSize(true)
        binding.recyclerViewSampleGrid.layoutManager = GridLayoutManager(requireContext(), COLUMN_NUM)
        binding.recyclerViewSampleGrid.adapter = SampleGridRecyclerViewAdapter(
            hogeList, presenter::onSampleItemClicked
        )
        binding.swipeRefreshLayoutSampleGrid.setOnRefreshListener(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun onRefresh() {
        presenter.onRefresh()
        binding.swipeRefreshLayoutSampleGrid.setRefreshing(false)
    }

    override fun showHogeGrid(hogeList: List<HogeModel>) {
        (binding.recyclerViewSampleGrid.adapter as SampleGridRecyclerViewAdapter)
            .update(hogeList)
    }

    override fun showToast(message: String) {
        val toast = Toast.makeText(
            this.activity,
            message,
            Toast.LENGTH_SHORT
        )
        toast.show()
    }

    override fun openSampleHomePage(hogeModel: HogeModel) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(hogeModel.url))
        startActivity(intent)
    }

    companion object{
        val COLUMN_NUM = 2
    }
}
