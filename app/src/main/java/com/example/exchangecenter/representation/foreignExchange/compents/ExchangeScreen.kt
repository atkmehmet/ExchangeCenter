package com.example.exchangecenter.representation.foreignExchange.compents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.exchangecenter.representation.foreignExchange.ForeighnExchangeViewModel

@Composable
fun ExScreen(
    viewModel: ForeighnExchangeViewModel= hiltViewModel()
){
           val state=viewModel.state.value
      Box (modifier = Modifier.fillMaxSize()){
                   LazyColumn(modifier = Modifier.fillMaxSize()){
                       items(state.exchangeList){
                           exchange->
                           ExchangeList(exchange = exchange)
                       }
                   }

          if(state.error.isNotBlank()){
              Text(text = state.error,
                  color= MaterialTheme.colorScheme.error,
                  textAlign = TextAlign.Center,
                  modifier = Modifier
                      .fillMaxWidth()
                      .align(Alignment.Center)
                      .padding(20.dp)
              )
          }
      }

    if (state.isloading){
       // CircularProgressIndicator()
    }
}