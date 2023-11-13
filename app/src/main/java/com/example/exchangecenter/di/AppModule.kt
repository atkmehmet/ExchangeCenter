package com.example.exchangecenter.di

import com.example.exchangecenter.common.Constants
import com.example.exchangecenter.data.remote.ForeignMoneyApi
import com.example.exchangecenter.data.repository.ExchangeRepositoryImpl
import com.example.exchangecenter.domain.repository.ExchangeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideExchangeApi():ForeignMoneyApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ForeignMoneyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api:ForeignMoneyApi):ExchangeRepository{
        return  ExchangeRepositoryImpl(api)
    }
}