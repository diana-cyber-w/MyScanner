package com.example.myscanner.presentation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myscanner.R
import com.example.myscanner.databinding.MainFragmentLayoutBinding

class MainFragment : Fragment(R.layout.main_fragment_layout) {

    private val binding: MainFragmentLayoutBinding by viewBinding(MainFragmentLayoutBinding::bind)

    override fun onStart() {
        super.onStart()
        binding.scannerButton.setOnClickListener {
            findNavController().navigate(R.id.toScanner)
        }
        binding.scannerHistoryButton.setOnClickListener {
            findNavController().navigate(R.id.toScannerHistory)
        }
    }
}