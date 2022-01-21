package com.example.mvvm.domain
import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.data.model.model.QuoteProvider
import javax.inject.Inject


class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

   // private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
            if (!quotes.isNullOrEmpty()){
                val randomNumber = (quotes.indices).random()
                return quotes[randomNumber]
            }
            return null
        }
    }