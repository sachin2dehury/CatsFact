package github.sachin2dehury.catsfact.paginated

import androidx.paging.PagingSource
import androidx.paging.PagingState
import github.sachin2dehury.catsfact.CatsFactRepository
import github.sachin2dehury.catsfact.singlefact.CatsFactResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CatsFactPagingSource(private val repository: CatsFactRepository) :
    PagingSource<Int, CatsFactResponse>() {
    override fun getRefreshKey(state: PagingState<Int, CatsFactResponse>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CatsFactResponse> =
        withContext(Dispatchers.IO) {
            val page = params.key ?: 1
            val limit = params.loadSize
            val response = repository.getFactsPaginated(page, limit).body()
            val nextPage = if (response?.nextPageUrl != null) page + 1 else null
            LoadResult.Page(response?.data?.filterNotNull().orEmpty(), null, nextPage)
        }
}
