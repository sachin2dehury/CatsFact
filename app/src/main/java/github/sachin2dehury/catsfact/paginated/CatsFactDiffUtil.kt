package github.sachin2dehury.catsfact.paginated

import androidx.recyclerview.widget.DiffUtil
import github.sachin2dehury.catsfact.singlefact.CatsFactResponse

class CatsFactDiffUtil : DiffUtil.ItemCallback<CatsFactResponse>() {
    override fun areItemsTheSame(oldItem: CatsFactResponse, newItem: CatsFactResponse): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CatsFactResponse, newItem: CatsFactResponse): Boolean {
        return oldItem == newItem
    }
}
