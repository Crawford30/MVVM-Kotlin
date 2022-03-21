package com.example.mvvmbasics.data

class QuoteRepository private constructor(private  val  quoteDao: FakeQuoteDao){
//Its mediator between data and the view model

    //ND: Dont create dependency inside the class but rather make them to passed as constructor in the class ie private constructor(private  val  quoteDao: FakeQuoteDao)

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes() //returns the live data on FakeQuoteDao

    //Singleton instantiation
    companion object {
        //volatile means writing to this object is visible to other threads
        @Volatile private var instance:QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this){
                //it means null coalasing, its syncrhonized bcause two thread can not be executed at the same time
                instance ?: QuoteRepository(quoteDao).also {
                    //also, run, apply in Kotlin(functions)
                    //Set instance property to equal to database instance
                    instance = it
                }

            }
    }
}