package com.example.mvvmbasics.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasics.data.QuoteRepository

class QuoteViewModelFactory(private val quoteRepository: QuoteRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return  QuotesViewModel(quoteRepository) as T
    }
}