package com.example.catgallery

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catgallery.adapter.CatAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var refreshButton: Button
    private lateinit var progressBar: ProgressBar

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        refreshButton = findViewById(R.id.refreshButton)
        progressBar = findViewById(R.id.progressBar)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe images from ViewModel
        viewModel.catImages.observe(this) { images ->
            recyclerView.adapter = CatAdapter(images)
        }

        // Observe loading state
        viewModel.isLoading.observe(this) { isLoading ->
            progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        // Observe error messages
        viewModel.errorMessage.observe(this) { error ->
            error?.let {
                Toast.makeText(this, "API Error: $it", Toast.LENGTH_LONG).show()
            }
        }

        // Load images initially
        viewModel.loadCatImages()

        // Setup Refresh button listener
        refreshButton.setOnClickListener {
            viewModel.loadCatImages()
        }
    }
}