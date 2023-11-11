package com.example.farmersandemployees.Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.farmersandemployees.DataClass.HistoryData
import com.example.farmersandemployees.R
import com.example.farmersandemployees.adapter.HistoryAdapter
import com.example.farmersandemployees.databinding.FragmentMyHistoryBinding
import java.util.*
import kotlin.collections.ArrayList

class MyHistoryFragment : Fragment() {
    private lateinit var binding: FragmentMyHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter
    private var historyList: ArrayList<HistoryData> = ArrayList()
    private var calendar: Calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMyHistoryBinding.bind(inflater.inflate(R.layout.fragment_my_history, null))
        showDatePicker()
        setUpListeners()
        initData()
        initView()
        return binding.root
    }



    private fun setUpListeners() {
        binding.datePickerButton.setOnClickListener {
            showDatePicker()
        }

    }

    private fun showDatePicker() {
        val datePicker = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            updateLabel()
        }

        val datePickerDialog = DatePickerDialog(
            requireContext(), datePicker, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        val minDate = Calendar.getInstance()
        datePickerDialog.datePicker.maxDate = minDate.timeInMillis
        minDate.add(Calendar.DAY_OF_YEAR, -7)
        datePickerDialog.datePicker.minDate = minDate.timeInMillis

        datePickerDialog.show()
    }

    private fun updateLabel() {
            val dateText = "Today - 7 days"
            binding.datePickerButton.text = dateText
        }


    private fun initData() {
        historyList.add(HistoryData("2023-11-12", "Logs for this place"))
        historyList.add(HistoryData("2023-11-11", "Logs for this place"))
        historyList.add(HistoryData("2023-11-12", "Logs for this place"))
        historyList.add(HistoryData("2023-11-11", "Logs for this place"))
        historyList.add(HistoryData("2023-11-12", "Logs for this place"))
        historyList.add(HistoryData("2023-11-11", "Logs for this place"))
    }
    private fun initView() {

        binding.historyRecyclerView.layoutManager = GridLayoutManager(context, 1)
        historyAdapter = HistoryAdapter(historyList)
        binding.historyRecyclerView.adapter = historyAdapter
        historyAdapter.notifyDataSetChanged()


    }
}
