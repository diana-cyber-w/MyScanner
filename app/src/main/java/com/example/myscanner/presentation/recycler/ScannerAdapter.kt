package com.example.myscanner.presentation.recycler

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myscanner.domain.Scan

class ScannerAdapter(
    private val itemClickListener: OnScanClickListener
) : RecyclerView.Adapter<ScannerViewHolder>() {

    private var items: List<Scan> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScannerViewHolder {
        return ScannerViewHolder.fromParent(parent, itemClickListener)
    }

    override fun onBindViewHolder(holder: ScannerViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(data: List<Scan>) {
        items = data
        notifyDataSetChanged()
    }
}