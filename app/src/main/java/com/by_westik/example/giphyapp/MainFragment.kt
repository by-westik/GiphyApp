package com.by_westik.example.giphyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.by_westik.example.giphyapp.data.remote.Resource
import com.by_westik.example.giphyapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    val viewModel: MainViewModel by viewModels()

    private fun getTrending(adapter: GiphyAdapter) {
        viewModel.getTrending().observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is Resource.Success -> {
                    result.data.let {
                        adapter.differ.submitList(it)
                    }
                    binding.progressBar.isGone = true
                }
                is Resource.Exception -> {
                    binding.progressBar.isGone = true
                }
            }

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val recyclerView = binding.recyclerview
        val adapter = GiphyAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        getTrending(adapter)

        binding.searchView.onQueryTextChanged(onQueryTextChanged = {
            viewModel.searching(it).observe(viewLifecycleOwner) {result ->
                when (result) {
                    is Resource.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is Resource.Success -> {
                        result.data.let {
                            adapter.differ.submitList(it)
                        }
                        binding.progressBar.isGone = true
                    }
                    is Resource.Exception -> {
                        binding.progressBar.isGone = true
                    }
                }
            }
        }, onTextCleared = {
            getTrending(adapter)
        })

        return binding.root
    }

}

inline fun SearchView.onQueryTextChanged(
    crossinline onQueryTextChanged: (String) -> Unit,
    crossinline onTextCleared: () -> Unit
) {
    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            onQueryTextChanged(query)
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            if (newText.isNullOrEmpty()) {
                onTextCleared()
            }
            return false
        }
    })
}