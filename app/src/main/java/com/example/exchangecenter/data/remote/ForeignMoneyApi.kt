package com.example.exchangecenter.data.remote

import com.example.exchangecenter.data.remote.dto.ForeignExchangeDto
import retrofit2.http.GET

interface ForeignMoneyApi {
    @GET("/perakende.json")
   suspend fun getForeignMoney():List<ForeignExchangeDto>

    }
