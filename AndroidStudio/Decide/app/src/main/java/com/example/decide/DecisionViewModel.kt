package com.example.decide

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DecisionViewModel : ViewModel() {

    private val categories = mapOf(
        "🍕 O que comer?" to listOf(
            "Pizza", "Sushi", "Hambúrguer", "Massa", "Salada",
            "Sopa", "Tacos", "Frango assado", "Piza de atum", "Bacalhau"
        ),
        "🎬 O que ver?" to listOf(
            "Filme de ação", "Série de comédia", "Documentário",
            "Anime", "Reality show", "Filme de terror", "Drama", "Sci-Fi"
        ),
        "🏃 O que fazer?" to listOf(
            "Dar uma caminhada", "Jogar videojogos", "Ler um livro",
            "Ouvir música", "Ligar a um amigo", "Fazer exercício",
            "Ver YouTube", "Desenhar", "Cozinhar algo novo"
        )
    )

    private val _currentCategory = MutableLiveData("🍕 O que comer?")
    val currentCategory: LiveData<String> = _currentCategory

    private val _result = MutableLiveData("")
    val result: LiveData<String> = _result

    private val _history = MutableLiveData<List<String>>(emptyList())
    val history: LiveData<List<String>> = _history

    fun setCategory(category: String) {
        _currentCategory.value = category
        _result.value = ""
    }

    fun decide() {
        val category = _currentCategory.value ?: return
        val options = categories[category] ?: return
        val decision = options.random()
        _result.value = decision

        val current = _history.value?.toMutableList() ?: mutableListOf()
        current.add(0, "[$category] $decision")
        _history.value = current
    }

    fun getCategories(): List<String> = categories.keys.toList()
}