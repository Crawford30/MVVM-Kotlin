package com.example.mvvmbasics.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmbasics.data.Quote
import com.example.mvvmbasics.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository):ViewModel() {

    //Constructor Injection

    //private val quoteRepository: QuoteRepository to prevent recreation chnages like potrait or landscape

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote:Quote) = quoteRepository.addQuote(quote)
}