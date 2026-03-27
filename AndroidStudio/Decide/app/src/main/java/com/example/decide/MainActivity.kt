package com.example.decide

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.decide.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DecisionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[DecisionViewModel::class.java]

        setupCategoryButtons()
        setupObservers()
        setupClickListeners()
    }

    private fun setupCategoryButtons() {
        binding.btnFood.setOnClickListener {
            viewModel.setCategory("🍕 O que comer?")
            updateCategoryButtons(0)
        }
        binding.btnWatch.setOnClickListener {
            viewModel.setCategory("🎬 O que ver?")
            updateCategoryButtons(1)
        }
        binding.btnDo.setOnClickListener {
            viewModel.setCategory("🏃 O que fazer?")
            updateCategoryButtons(2)
        }
    }

    private fun updateCategoryButtons(selected: Int) {
        val buttons = listOf(binding.btnFood, binding.btnWatch, binding.btnDo)
        buttons.forEachIndexed { index, button ->
            if (index == selected) {
                button.alpha = 1.0f
                button.scaleX = 1.05f
                button.scaleY = 1.05f
            } else {
                button.alpha = 0.6f
                button.scaleX = 1.0f
                button.scaleY = 1.0f
            }
        }
    }

    private fun setupObservers() {
        viewModel.currentCategory.observe(this) { category ->
            binding.tvCategory.text = category
        }
        viewModel.result.observe(this) { result ->
            if (result.isNotEmpty()) {
                binding.tvResult.text = result
                val anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
                binding.tvResult.startAnimation(anim)
            }
        }
    }

    private fun setupClickListeners() {
        binding.btnDecide.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
            binding.tvResult.startAnimation(anim)
            viewModel.decide()
        }

        binding.btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            // Passa o histórico completo para a activity de histórico
            intent.putStringArrayListExtra(
                "history",
                ArrayList(viewModel.history.value ?: emptyList())
            )
            startActivity(intent)
        }
    }
}