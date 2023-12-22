package com.example.produkcomposeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.produkcomposeapp.data.Repository
import com.example.produkcomposeapp.ui.detail.DetailViewModel
import com.example.produkcomposeapp.ui.main.MainViewModel

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainViewModel::class.java) ->
                MainViewModel(repository) as T

            modelClass.isAssignableFrom(DetailViewModel::class.java) ->
                DetailViewModel(repository) as T

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}