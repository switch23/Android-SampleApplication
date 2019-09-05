package switch23.sampleapplication.presentation.samplepager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import switch23.sampleapplication.presentation.samplepager.page1.Page1Fragment
import switch23.sampleapplication.presentation.samplepager.page2.Page2Fragment

class SamplePagerAdapter(
    private val tabTitles: List<String>,
    fragmentManager: FragmentManager
) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = tabTitles[position]

    override fun getItem(position: Int): Fragment = when (position) {
        0 -> Page1Fragment()
        1 -> Page2Fragment()
        else -> Page1Fragment()
    }
}
