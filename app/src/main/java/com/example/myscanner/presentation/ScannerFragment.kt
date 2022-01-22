package com.example.myscanner.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.example.myscanner.DaggerApplication
import com.example.myscanner.R
import com.example.myscanner.databinding.CodeScannerLayoutBinding
import com.example.myscanner.domain.Scan
import com.example.myscanner.utils.dateInString
import javax.inject.Inject


class ScannerFragment : Fragment(R.layout.code_scanner_layout) {

    private lateinit var codeScanner: CodeScanner
    private val binding: CodeScannerLayoutBinding by viewBinding(CodeScannerLayoutBinding::bind)
    private var newScan = Scan("", "")

    @Inject
    lateinit var viewModel: SharedViewModel

    init {
        DaggerApplication.appComponent?.inject(this)
    }

    companion object {
        private const val CAMERA_REQUEST_CODE = 1000
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (checkPermission()) {
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
        } else {
            requestPermission();
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

    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(), arrayOf(Manifest.permission.CAMERA),
            CAMERA_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    codeScanner = CodeScanner(requireActivity(), binding.scannerView)
                    codeScanner.decodeCallback = DecodeCallback { scan ->
                        newScan.text = scan.text
                        newScan.date = dateInString
                        viewModel.insertScan(newScan)
                    }
                    binding.scannerView.setOnClickListener {
                        codeScanner.startPreview()
                    }
                } else {
                    Toast.makeText(
                        requireContext(), "You need to grant permission to access camera",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}