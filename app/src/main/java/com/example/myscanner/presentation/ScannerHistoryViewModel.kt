package com.example.myscanner.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myscanner.domain.Scan
import com.example.myscanner.domain.ScannerInteractor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScannerHistoryViewModel @Inject constructor(
    private val scannerInteractor: ScannerInteractor
) : ViewModel() {

    val scan: LiveData<List<Scan>> get() = _scan
    private val _scan = MutableLiveData<List<Scan>>()

    init {
        loadScans()
    }

    private fun loadScans() {
        viewModelScope.launch {
            scannerInteractor.getScan().collect { scans ->
                _scan.value = scans
            }
        }
    }
}