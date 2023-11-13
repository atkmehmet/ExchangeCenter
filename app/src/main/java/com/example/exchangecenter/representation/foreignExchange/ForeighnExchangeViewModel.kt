package com.example.exchangecenter.representation.foreignExchange

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangecenter.common.Resource
import com.example.exchangecenter.domain.use_case.getForeignExhange.GetExchange
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ForeighnExchangeViewModel @Inject constructor(
    private  val getExchange: GetExchange
):ViewModel() {

    private val _state= mutableStateOf(ExchangeListState())
     val state: State<ExchangeListState> = _state

    init {
        getExc()
    }

    private  fun getExc()
    {
        getExchange().onEach {  result->
            when(result){
                is Resource.Success->{
                    _state.value= ExchangeListState(exchangeList = result.data?: emptyList())
            }
               is Resource.Error->{
                      _state.value= ExchangeListState(error = result.message?:"An unexpected error occured")
               }
                is Resource.Loading->{
                    _state.value= ExchangeListState(isloading = true)
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }

}