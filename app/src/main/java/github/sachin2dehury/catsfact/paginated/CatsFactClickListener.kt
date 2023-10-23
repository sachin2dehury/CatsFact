package github.sachin2dehury.catsfact.paginated

import github.sachin2dehury.catsfact.singlefact.CatsFactResponse

interface CatsFactClickListener {
    fun onClick(position: Int, item: CatsFactResponse?)
}
