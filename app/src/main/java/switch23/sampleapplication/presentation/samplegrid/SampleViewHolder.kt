package switch23.sampleapplication.presentation.samplegrid

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import switch23.sampleapplication.databinding.ItemRecyclerViewSampleGridBinding
import switch23.sampleapplication.util.nonConcurrentLazy

class SampleViewHolder(
    val binding: ItemRecyclerViewSampleGridBinding
) : RecyclerView.ViewHolder(binding.root) {
    val id: TextView by nonConcurrentLazy {
        binding.textGridHogeId
    }
    val title: TextView by nonConcurrentLazy {
        binding.textGridHogeTitle
    }
    val body: TextView by nonConcurrentLazy {
        binding.textGridHogeBody
    }
}
