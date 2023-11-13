package com.example.exchangecenter.data.remote.dto

import com.example.exchangecenter.domain.model.ForeignExchange

data class ForeignExchangeDto(
    val adi: String,
    val basamak: Int,
    val kodu: String,
    val sekme: Int,
    val sonalis: String,
    val sonsatis: String,
    val tipi: Int
)
fun ForeignExchangeDto.toForeignExchange():ForeignExchange{
    return ForeignExchange(
        adi=adi,
        kodu=kodu,
        sonalis=sonalis,
        sonsatis=sonsatis
    )
}