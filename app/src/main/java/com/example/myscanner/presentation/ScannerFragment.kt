package com.example.myscanner.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.example.myscanner.DaggerApplication
import com.example.myscanner.R
import com.example.myscanner.databinding.CodeScannerLayoutBinding
import com.example.myscanner.domain.Scan
import com.example.myscanner.utils.PermissionManager
import com.example.myscanner.utils.dateInString
import javax.inject.Inject


class ScannerFragment : Fragment(R.layout.code_scanner_layout) {

    private lateinit var codeScanner: CodeScanner
    private val binding: CodeScannerLayoutBinding by viewBinding(CodeScannerLayoutBinding::bind)
    private var newScan = Scan("", "")

    @Inject
    lateinit var viewModel: ScannerViewModel

    @Inject
    lateinit var permissionManager: PermissionManager

    init {
        DaggerApplication.appComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (permissionManager.isCameraPermissionGranted(requireActivity())) {
            codeScanner = CodeScanner(requireActivity(), binding.scannerView)
            codeScanner.decodeCallback = DecodeCallback { scan ->
                activity?.runOnUiThread {
                    newScan.text = scan.text
                    newScan.date = dateInString
                    viewModel.insertScan(newScan)
                }
            }
            binding.scannerView.setOnClickListener {
                codeScanner.startPreview()
            }
        }
        binding.mainFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.toMainFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}