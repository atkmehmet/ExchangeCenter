package com.example.exchangecenter.representation.foreignExchange

import com.example.exchangecenter.domain.model.ForeignExchange

data class ExchangeListState (
    val isloading:Boolean=false,
    val exchangeList:List<ForeignExchange> = emptyList(),
    val error:String=""
)