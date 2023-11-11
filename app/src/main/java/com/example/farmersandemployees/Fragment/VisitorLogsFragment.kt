package com.example.farmersandemployees.Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.farmersandemployees.DataClass.VisitorData
import com.example.farmersandemployees.R
import com.example.farmersandemployees.adapter.VisitorAdapter
import com.example.farmersandemployees.databinding.FragmentVisitorLogsBinding
import java.util.Calendar


class VisitorLogsFragment : Fragment() {
    private lateinit var binding:FragmentVisitorLogsBinding
    private lateinit var visitorAdapter: VisitorAdapter
    private var visitorList: ArrayList<VisitorData> = ArrayList()
    private var calendar: Calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentVisitorLogsBinding.bind(inflater.inflate(R.layout.fragment_visitor_logs,null))
        showDatePicker()
        initData()
        initView()
        return binding.root
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
        visitorList.add(VisitorData("John Doe", "Cafeteria", "2023-11-12", "2023-11-12"))
        visitorList.add(VisitorData("Alice Smith", "Reception", "2023-11-11", "2023-11-12"))
        visitorList.add(VisitorData("John Doe", "Cafeteria", "2023-11-12", "2023-11-12"))
        visitorList.add(VisitorData("Alice Smith", "Reception", "2023-11-11", "2023-11-12"))
        visitorList.add(VisitorData("John Doe", "Cafeteria", "2023-11-12", "2023-11-12"))
        visitorList.add(VisitorData("Alice Smith", "Reception", "2023-11-11", "2023-11-12"))
        visitorList.add(VisitorData("John Doe", "Cafeteria", "2023-11-12", "2023-11-12"))
        visitorList.add(VisitorData("Alice Smith", "Reception", "2023-11-11", "2023-11-12"))

    }

    private fun initView() {

        binding.historyRecyclerView.layoutManager = GridLayoutManager(context, 1)
        visitorAdapter = VisitorAdapter(visitorList)
        binding.historyRecyclerView.adapter = visitorAdapter
        visitorAdapter.notifyDataSetChanged()


    }
}

