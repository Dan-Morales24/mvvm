package com.example.mvvm.domain
import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.data.model.model.QuoteProvider

class GetRandomQuoteUseCase {

   // private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
            if (!quotes.isNullOrEmpty()){
                val randomNumber = (quotes.indices).random()
                return quotes[randomNumber]
            }
            return null
        }
    }