package switch23.sampleapplication.presentation.samplegrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import switch23.sampleapplication.databinding.ItemRecyclerViewSampleGridBinding
import switch23.sampleapplication.domain.model.HogeModel

class SampleGridRecyclerViewAdapter(
    private var hogeList: List<HogeModel>,
    private val onSampleItemClickedAction: (HogeModel) -> Unit
) : RecyclerView.Adapter<SampleViewHolder>() {

    override fun getItemCount() = hogeList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SampleViewHolder(
        ItemRecyclerViewSampleGridBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.binding.hogeModel = hogeList[position]
        holder.binding.setOnSampleGridItemClick {
            onSampleItemClickedAction(hogeList[position])
        }
    }

    fun update(new: List<HogeModel>) {
        val diffResult = DiffUtil
            .calculateDiff(RecyclerDiffCallback(this.hogeList, new))
        diffResult.dispatchUpdatesTo(this)
    }

    class RecyclerDiffCallback(
        private val old: List<HogeModel>,
        private val new: List<HogeModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = old.size

        override fun getNewListSize(): Int = new.size

        override fun areItemsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean = old[oldItemPosition].id == new[newItemPosition].id

        override fun areContentsTheSame(
            oldItemPosition: Int,
            newItemPosition: Int
        ): Boolean = old[oldItemPosition] == new[newItemPosition]
    }

}
