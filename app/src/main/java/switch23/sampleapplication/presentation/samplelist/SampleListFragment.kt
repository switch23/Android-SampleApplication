package switch23.sampleapplication.presentation.samplelist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import switch23.sampleapplication.R
import switch23.sampleapplication.databinding.FragmentSampleListBinding
import switch23.sampleapplication.domain.model.HogeModel
import switch23.sampleapplication.util.LifecycleScope

class SampleListFragment : Fragment(),
    SampleListView,
    SwipeRefreshLayout.OnRefreshListener {

    private lateinit var binding: FragmentSampleListBinding
    private lateinit var presenter: SampleListPresenter
    override val scope = LifecycleScope(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SampleListPresenter(this, requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_sample_list,
            container,
            false
        )

        val hogeList = listOf<HogeModel>()
        binding.recyclerViewSampleList.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewSampleList.adapter = SampleListRecyclerViewAdapter(
            hogeList, presenter::onSampleItemClicked
        )
        binding.swipeRefreshLayoutSampleList.setOnRefreshListener(this)

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
        binding.swipeRefreshLayoutSampleList.setRefreshing(false)
    }

    override fun showHogeList(hogeList: List<HogeModel>) {
        (binding.recyclerViewSampleList.adapter as SampleListRecyclerViewAdapter)
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
}
