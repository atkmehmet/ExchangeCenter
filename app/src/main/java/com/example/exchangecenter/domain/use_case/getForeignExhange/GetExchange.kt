package com.example.exchangecenter.domain.use_case.getForeignExhange

import com.example.exchangecenter.common.Resource
import com.example.exchangecenter.data.remote.dto.toForeignExchange
import com.example.exchangecenter.domain.model.ForeignExchange
import com.example.exchangecenter.domain.repository.ExchangeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetExchange @Inject constructor(
    private val repository: ExchangeRepository
) {
    operator fun invoke(): Flow<Resource<List<ForeignExchange>>> = flow {

        try {
                  emit(Resource.Loading())
                 val exchange=repository.getForeignExchange().map { it.toForeignExchange() }
                 emit(Resource.Success(exchange))
        }
        catch (e:HttpException)
        {
                  emit(Resource.Error(e.localizedMessage?:"An unexpected error occured."))
        }
        catch (e:IOException)
        {
                emit(Resource.Error("Couldn't reach server. Check your internet."))
        }
    }
}