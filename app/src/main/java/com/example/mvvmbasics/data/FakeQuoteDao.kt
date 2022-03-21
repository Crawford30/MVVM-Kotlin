package com.example.mvvmbasics.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {

    //can use ROOM incase of SQL

    private  val quoteList = mutableListOf<Quote>()

    private val quotes = MutableLiveData<List<Quote>>()

    //we can observe the quotes from repository and in the view model

    init {
        //Connect the quotes value to mutable empty list
        quotes.value = quoteList
    }


    //Data access will have two functions:
    //1. One for entering and 2.for getting quotes

    fun addQuote(quote: Quote){
        quoteList.add(quote)

        //update mutable quote values(mutable live data)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>


}