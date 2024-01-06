package com.jotap.calc_220001295.Calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jotap.calc_220001295.ui.theme.MyBlue1


@Composable
fun CFrontEnd (

    state: CState,
    modifier: Modifier = Modifier,
    bottonSpacing: Dp = 7.dp

) {
    Box(
        modifier = modifier
    ) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(7.dp), //devia levar a variavel buttonSpacing
        ){
            Text(
                text = state.val_number1 + (state.operation ?: "") + state.val_number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
               modifier = Modifier
                   .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ){
              CButton(
                  symbol = "AC",
                  modifier = Modifier
                      .background(MyBlue1)
                      .aspectRatio(1f)
                      .weight(2f),
                  onClick = {
                      onAction(CAction.Clear)
                  }
              ) {

              }
            }
    }

    }
}