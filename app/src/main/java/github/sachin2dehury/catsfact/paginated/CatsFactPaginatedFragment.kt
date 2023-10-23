package github.sachin2dehury.catsfact.paginated

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import github.sachin2dehury.catsfact.R
import github.sachin2dehury.catsfact.databinding.FragmentPaginatedBinding
import github.sachin2dehury.catsfact.singlefact.CatsFactResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatsFactPaginatedFragment : Fragment(R.layout.fragment_paginated), CatsFactClickListener {

    private var binding: FragmentPaginatedBinding? = null

    private val pagingAdapter = CatsFactAdapter(this)

    private val viewModel: CatsFactPaginatedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPaginatedBinding.bind(view)

        setupUi()

        subscribeToObserver()
    }

    private fun setupUi() = binding?.run {
        recycler.adapter = pagingAdapter
    }

    private fun subscribeToObserver() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getPager().collectLatest {
                pagingAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onClick(position: Int, item: CatsFactResponse?) {
        Toast.makeText(requireContext(), "$position ${item?.fact}", Toast.LENGTH_SHORT).show()
    }
}
