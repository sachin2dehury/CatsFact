package github.sachin2dehury.catsfact.singlefact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import github.sachin2dehury.catsfact.CatsFactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsSingleFactViewModel @Inject constructor(private val repository: CatsFactRepository) :
    ViewModel() {

    private val _catsSingleFact = MutableStateFlow<CatsFactResponse?>(null)
    val catsSingleFact = _catsSingleFact.asStateFlow()

    private fun fetchSingleFact() = viewModelScope.launch(Dispatchers.IO) {
        while (true) {
            delay(3000)
            _catsSingleFact.value = repository.getSingleFact().body()
        }
    }

    init {
        fetchSingleFact()
    }
}
