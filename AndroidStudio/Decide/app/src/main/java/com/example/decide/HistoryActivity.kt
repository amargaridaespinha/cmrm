package com.example.decide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.decide.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "📋 Histórico"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val historyList = intent.getStringArrayListExtra("history") ?: arrayListOf()

        val adapter = HistoryAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        if (historyList.isEmpty()) {
            binding.tvEmpty.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
        } else {
            binding.tvEmpty.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            adapter.submitList(historyList)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private var items: List<String> = emptyList()

    fun submitList(list: List<String>) {
        items = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvItem: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItem.text = items[position]
        holder.tvItem.textSize = 16f
        holder.tvItem.setPadding(32, 24, 32, 24)
    }

    override fun getItemCount() = items.size
}