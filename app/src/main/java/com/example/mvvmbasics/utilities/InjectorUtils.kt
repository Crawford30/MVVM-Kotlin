package com.example.mvvmbasics.utilities

import com.example.mvvmbasics.data.FakeDatabase
import com.example.mvvmbasics.data.FakeQuoteDao
import com.example.mvvmbasics.data.QuoteRepository
import com.example.mvvmbasics.ui.quotes.QuoteViewModelFactory

//Dependency injections

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuoteViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return  QuoteViewModelFactory(quoteRepository)
    }
}