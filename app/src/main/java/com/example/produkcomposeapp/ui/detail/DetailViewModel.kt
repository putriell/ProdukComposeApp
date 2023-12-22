package com.example.produkcomposeapp.ui.detail

import androidx.lifecycle.ViewModel
import com.example.produkcomposeapp.data.ListProduk
import com.example.produkcomposeapp.data.Repository

class DetailViewModel (private val repository: Repository) : ViewModel(){
    fun getProductById(id: String): ListProduk {
        return repository.searchDataById(id)
    }
}