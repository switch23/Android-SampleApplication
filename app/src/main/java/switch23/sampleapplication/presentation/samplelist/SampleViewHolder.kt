package switch23.sampleapplication.presentation.samplelist

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import switch23.sampleapplication.databinding.ItemRecyclerViewSampleListBinding
import switch23.sampleapplication.util.nonConcurrentLazy

class SampleViewHolder(
    val binding: ItemRecyclerViewSampleListBinding
) : RecyclerView.ViewHolder(binding.root) {
    val id: TextView by nonConcurrentLazy {
        binding.textListHogeId
    }
    val title: TextView by nonConcurrentLazy {
        binding.textListHogeTitle
    }
    val body: TextView by nonConcurrentLazy {
        binding.textListHogeBody
    }
}
