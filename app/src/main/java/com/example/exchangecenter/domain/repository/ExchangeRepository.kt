package com.example.exchangecenter.domain.repository

import com.example.exchangecenter.data.remote.dto.ForeignExchangeDto

interface ExchangeRepository {

    suspend fun getForeignExchange():List<ForeignExchangeDto>
}