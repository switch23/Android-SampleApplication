package switch23.sampleapplication.presentation.main

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import switch23.sampleapplication.R
import switch23.sampleapplication.databinding.ActivityMainBinding
import switch23.sampleapplication.presentation.samplegrid.SampleGridFragment
import switch23.sampleapplication.presentation.samplelist.SampleListFragment
import switch23.sampleapplication.presentation.samplepager.SamplePagerFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setCurrentScreen(ScreenType.LIST)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            BOTTOM_NAVIGATION_VIEW_TO_SCREEN_TYPE[item.itemId]?.let(::setCurrentScreen)
            return@setOnNavigationItemSelectedListener true
        }

        homeButtonOff()
        invalidateOptionsMenu()
    }

    private fun setCurrentScreen(screenType: ScreenType) {
        SCREEN_TYPE_TO_FRAGMENT[screenType]?.let { replaceFragment(it.invoke()) }
        SCREEN_TYPE_TO_TITLE[screenType]?.let(::setActionBarTitle)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun setActionBarTitle(@StringRes titleRes: Int) {
        supportActionBar?.setTitle(titleRes)
    }

    private fun homeButtonOff() {
        supportActionBar?.setHomeButtonEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private enum class ScreenType {
        LIST, GRID, PAGER
    }

    companion object {
        private val SCREEN_TYPE_TO_FRAGMENT = mapOf(
            ScreenType.LIST to { SampleListFragment() },
            ScreenType.GRID to { SampleGridFragment() },
            ScreenType.PAGER to { SamplePagerFragment() }
        )
        private val SCREEN_TYPE_TO_TITLE = mapOf(
            ScreenType.LIST to R.string.list,
            ScreenType.GRID to R.string.grid,
            ScreenType.PAGER to R.string.pager
        )
        private val BOTTOM_NAVIGATION_VIEW_TO_SCREEN_TYPE = mapOf(
            R.id.sample_list to ScreenType.LIST,
            R.id.sample_grid to ScreenType.GRID,
            R.id.sample_pager to ScreenType.PAGER
        )
    }
}
