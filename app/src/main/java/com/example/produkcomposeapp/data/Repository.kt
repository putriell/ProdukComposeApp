package com.example.produkcomposeapp.data

class Repository {

    fun getData() : List<ListProduk>{
        return  ProdukData.produk
    }

    fun searchData(query: String): List<ListProduk>{
        val data  = ProdukData.produk.filter {
            it.name.contains(query, ignoreCase = true)
        }
        return data.ifEmpty {
            ProdukData.produk
        }
    }

    fun searchDataById(id: String): ListProduk{
        return ProdukData.produk.first{
            it.id == id
        }
    }
}