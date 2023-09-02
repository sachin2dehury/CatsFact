package github.sachin2dehury.catsfact.paginated

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import github.sachin2dehury.catsfact.CatsFactRepository
import javax.inject.Inject

@HiltViewModel
class CatsFactPaginatedViewModel @Inject constructor(private val repository: CatsFactRepository) :
    ViewModel() {

    private val pagingConfig = PagingConfig(10)

    fun getPager() = Pager(pagingConfig, 1) {
        CatsFactPagingSource(repository)
    }
}
