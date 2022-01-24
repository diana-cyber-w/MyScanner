package com.example.myscanner.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myscanner.R
import com.example.myscanner.databinding.ScannerHistoryItemLayoutBinding
import com.example.myscanner.domain.Scan
import kotlinx.android.synthetic.main.scanner_history_item_layout.view.*

class ScannerViewHolder(
    itemView: View,
    private val itemClickListener: OnScanClickListener
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun fromParent(parent: ViewGroup, itemClickListener: OnScanClickListener) =
            ScannerViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.scanner_history_item_layout, parent, false),
                itemClickListener
            )
    }

    private val binding: ScannerHistoryItemLayoutBinding by viewBinding(
        ScannerHistoryItemLayoutBinding::bind
    )
    private val text: TextView by lazy { itemView.scanText }
    private val date: TextView by lazy { itemView.timeView }
    private val button: ImageButton by lazy { itemView.shareButton }

    fun bindView(item: Scan) {
        text.text = item.text
        date.text = item.date
        binding.shareButton.setOnClickListener {
            itemClickListener.startShareIntent(adapterPosition)
        }
    }
}