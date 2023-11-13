package com.example.exchangecenter.data.repository

import com.example.exchangecenter.data.remote.ForeignMoneyApi
import com.example.exchangecenter.data.remote.dto.ForeignExchangeDto
import com.example.exchangecenter.domain.repository.ExchangeRepository
import javax.inject.Inject

class ExchangeRepositoryImpl @Inject constructor(
    private val api:ForeignMoneyApi
):ExchangeRepository {


    override suspend fun getForeignExchange(): List<ForeignExchangeDto> {
       return api.getForeignMoney()
    }
}