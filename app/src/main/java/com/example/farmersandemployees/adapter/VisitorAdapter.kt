package com.example.farmersandemployees.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmersandemployees.DataClass.HistoryData
import com.example.farmersandemployees.DataClass.VisitorData
import com.example.farmersandemployees.databinding.VisitorsViewBinding

class VisitorAdapter(private val visitorList: ArrayList<VisitorData>) : RecyclerView.Adapter<VisitorAdapter.VisitorViewHolder>() {

    class VisitorViewHolder(val binding: VisitorsViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(visitorData: VisitorData) {
            binding.visitorNameTextView.text = visitorData.visitorName
            binding.placeTextView.text = visitorData.place
            binding.dateTextView.text = visitorData.date
            binding.logsTextView.text = visitorData.logs
        }
    }

    override fun getItemCount() =visitorList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisitorViewHolder {
        val binding = VisitorsViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VisitorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VisitorViewHolder, position: Int) {
        val visitorData = visitorList[position]
        holder.bind(visitorData)
    }
}
