package com.example.mvvmbasics.data

class FakeDatabase  private constructor( ){
    var quoteDao = FakeQuoteDao()

    private set


    //private constructor:its private so that it can not be invoked outside this class
    //Singleton
    companion object {
        //volatile means writing to this object is visible to other threads
        @Volatile private var instance:FakeDatabase? = null

        fun getInstance() =
            instance ?: synchronized(this){
                //it means null coalasing, its syncrhonized bcause two thread can not be executed at the same time
                instance ?: FakeDatabase().also {
                    //also, run, apply in Kotlin(functions)
                    //Set instance property to equal to database instance
                    instance = it
                }

            }
    }
}