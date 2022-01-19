package com.example.mvvm.domain

import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.data.model.model.QuoteModel

class GetCuotesUseCase {

    private  val repository = QuoteRepository()
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}