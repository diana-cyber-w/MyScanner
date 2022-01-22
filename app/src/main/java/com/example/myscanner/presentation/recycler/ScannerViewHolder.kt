package com.example.myscanner.presentation.recycler

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.myscanner.R
import com.example.myscanner.databinding.ScannerHistoryItemLayoutBinding
import com.example.myscanner.domain.Scan
import kotlinx.android.synthetic.main.scanner_history_item_layout.view.*

class ScannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun fromParent(parent: ViewGroup) =
            ScannerViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.scanner_history_item_layout, parent, false)
            )
    }

    private val binding: ScannerHistoryItemLayoutBinding by viewBinding(
        ScannerHistoryItemLayoutBinding::bind
    )
    private val text: TextView by lazy { itemView.scanText }
    private val date: TextView by lazy { itemView.timeView }

    fun bindView(item: Scan) {
        text.text = item.text
        date.text = item.date
        binding.shareButton.setOnClickListener {
            startShareIntent()
        }
    }

    private fun startShareIntent() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text.text)
        }
        startActivity(itemView.context, Intent.createChooser(intent, "qr code"), intent.extras)
    }
}