package com.example.mvvm.ui.viewmodel

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.model.QuoteModel
import com.example.mvvm.data.model.model.QuoteProvider
import com.example.mvvm.domain.GetCuotesUseCase
import com.example.mvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class QuoteViewModel @Inject constructor(

    private val getQuotesUseCase : GetCuotesUseCase,
    private val getRandomQuoteUseCase : GetRandomQuoteUseCase

) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()




    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()
                if (!result.isNullOrEmpty()){

                    quoteModel.postValue(result[0])
                    isLoading.postValue(false)

                }
            }
        }


    fun randomQuote(){

        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)


    }


}


