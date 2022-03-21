package com.example.mvvmbasics.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmbasics.R
import com.example.mvvmbasics.data.Quote
import com.example.mvvmbasics.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUI()

    }

    private fun initializeUI(){

        //Get quote view model factory from the injector utils
        val factory = InjectorUtils.provideQuotesViewModelFactory()

        //Get view model(ask viewmodel provider to provide us with present or al;ready instantiated QuotesViewModel
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        //Observe
        viewModel.getQuotes().observe(this, Observer {
            quotes ->
            val stringBuilder = StringBuilder()

            quotes.forEach {
                quote -> stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString() )

            //add the quote thru the view model, which will pass it to the databse
            viewModel.addQuotes(quote)

            editText_quote.setText("")
            editText_author.setText("")
        }

    }

    ////https://www.youtube.com/watch?v=d7UxPYxgBoA


}