package github.sachin2dehury.catsfact.singlefact

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import github.sachin2dehury.catsfact.R
import github.sachin2dehury.catsfact.databinding.FragmentSingleFactBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatsSingleFactFragment : Fragment(R.layout.fragment_single_fact) {

    private val viewModel: CatsSingleFactViewModel by viewModels()

    private var binding: FragmentSingleFactBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSingleFactBinding.bind(view)
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.catsSingleFact.filterNotNull().collectLatest {
                binding?.factTv?.text = it.fact
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
