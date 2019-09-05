package switch23.sampleapplication.presentation.samplepager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import switch23.sampleapplication.R
import switch23.sampleapplication.databinding.FragmentSamplePagerBinding

class SamplePagerFragment : Fragment() {

    private lateinit var binding: FragmentSamplePagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sample_pager, container, false)

        val tabTitles = listOf(getString(R.string.page1), getString(R.string.page2))

        binding.viewPagerSamplePager.offscreenPageLimit = 2
        binding.viewPagerSamplePager.adapter = SamplePagerAdapter(tabTitles, childFragmentManager)
        binding.tabLayoutSamplePager.setupWithViewPager(binding.viewPagerSamplePager)

        return binding.root
    }
}
