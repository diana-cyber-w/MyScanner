package com.example.myscanner.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myscanner.DaggerApplication
import com.example.myscanner.R
import com.example.myscanner.databinding.ScannerHistoryLayoutBinding
import com.example.myscanner.presentation.recycler.ScannerAdapter
import javax.inject.Inject

class ScannerHistoryFragment : Fragment(R.layout.scanner_history_layout) {

    private val binding: ScannerHistoryLayoutBinding by viewBinding(ScannerHistoryLayoutBinding::bind)
    private val adapter by lazy { ScannerAdapter() }

    @Inject
    lateinit var viewModel: SharedViewModel

    init {
        DaggerApplication.appComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initObserves()
        viewModel.loadScans()
        binding.mainFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.toMainFragment)
        }
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
    }

    private fun initObserves() {
        viewModel.scan.observe(viewLifecycleOwner) { news ->
            adapter.submitList(news)
        }
    }
}