package com.example.farmersandemployees.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmersandemployees.DataClass.HistoryData
import com.example.farmersandemployees.databinding.DateLogViewBinding

class HistoryAdapter(private val historyList: List<HistoryData>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(val binding: DateLogViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(historyData: HistoryData) {
            binding.dateTextView.text = historyData.date
            binding.logsTextView.text = historyData.logs
        }
    }

    override fun getItemCount() = historyList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = DateLogViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyData = historyList[position]
        holder.bind(historyData)
    }
}
