package com.example.produkcomposeapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.compose.runtime.State
import com.example.produkcomposeapp.data.ListProduk
import com.example.produkcomposeapp.data.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val _groupProduk = MutableStateFlow(
        repository.getData()
            .groupBy { it.name[0] }
    )

    val groupProduk : StateFlow<Map<Char, List<ListProduk>>> get() = _groupProduk

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(data: String){
        _query.value = data
        _groupProduk.value = repository.searchData(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }

}