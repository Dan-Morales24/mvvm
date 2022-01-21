package com.example.mvvm.domain

import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.data.model.model.QuoteModel
import javax.inject.Inject

class GetCuotesUseCase @Inject constructor(

    private  val repository : QuoteRepository

){


    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}