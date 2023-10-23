package github.sachin2dehury.catsfact.paginated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import github.sachin2dehury.catsfact.databinding.CatsFactItemBinding
import github.sachin2dehury.catsfact.singlefact.CatsFactResponse

class CatsFactAdapter(private val onClickListener: CatsFactClickListener) :
    PagingDataAdapter<CatsFactResponse, CatsFactViewHolder>(CatsFactDiffUtil()) {

    override fun onBindViewHolder(holder: CatsFactViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.factTv.text = item?.fact
        holder.binding.root.setOnClickListener {
            onClickListener.onClick(position, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsFactViewHolder {
        val binding = CatsFactItemBinding.inflate(LayoutInflater.from(parent.context))
        return CatsFactViewHolder(binding)
    }
}
