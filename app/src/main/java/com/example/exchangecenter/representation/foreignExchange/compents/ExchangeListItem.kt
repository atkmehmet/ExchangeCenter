package com.example.exchangecenter.representation.foreignExchange.compents


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextOverflow
import com.example.exchangecenter.domain.model.ForeignExchange

@Composable
fun ExchangeList(
    exchange: ForeignExchange
){
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
              Text(text = "${exchange.adi} Alis: ${exchange.sonalis} Satis: ${exchange.sonsatis}",
              style = MaterialTheme.typography.bodyLarge,
                  overflow = TextOverflow.Ellipsis
              )
    }
}