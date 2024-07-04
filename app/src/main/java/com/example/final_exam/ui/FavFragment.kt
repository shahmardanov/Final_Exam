package com.example.test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.final_exam.databinding.FavFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavFragment : Fragment() {

    private var _binding: FavFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FavViewModel>()
    private val adapter = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFav.adapter=adapter
        viewModel.getLocalProduct()
        observeData()
    }

    private fun observeData() {
    viewModel.favList.observe(viewLifecycleOwner){
        adapter.updateList(it)
    }
}

override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
}