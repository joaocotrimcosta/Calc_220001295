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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jotap.calc_220001295.ui.theme.MyBlue1
import com.jotap.calc_220001295.ui.theme.MyBlue2
import com.jotap.calc_220001295.ui.theme.MyBlue4


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CFrontEnd(

    state: CState,
    modifier: Modifier = Modifier,
    bottonSpacing: Dp = 7.dp,
    onAction: (CAction) -> Unit

) {
    Box(
        modifier = modifier
    ) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(bottonSpacing),
        ) {
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(bottonSpacing)
            ) {
                CButton(symbol = "AC",
                    modifier = Modifier
                        .background(MyBlue4)
                        .aspectRatio(1f)
                        .weight(2f),
                    onClick = {
                        onAction(CAction.Clear)
                    })
                CButton(symbol = "Del",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(2f),
                    onClick = {
                        onAction(CAction.Delete)
                    })
                CButton(symbol = "%",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(2f),
                    onClick = {
                        onAction(CAction.Percentage)
                    })
                CButton(symbol = "/",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(2f),
                    onClick = {
                        onAction(CAction.Operation(COperation.Divide))
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(bottonSpacing)
            ) {
                CButton(symbol = "7",
                    modifier = Modifier
                        .background(MyBlue2)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CAction.Number(7))
                    })
                CButton(symbol = "8",
                    modifier = Modifier
                        .background(MyBlue2)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CAction.Number(8))
                    })
                CButton(symbol = "9",
                    modifier = Modifier
                        .background(MyBlue2)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CAction.Number(9))
                    })
                CButton(symbol = "*",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(2f),
                    onClick = {
                        onAction(CAction.Operation(COperation.Multiply))
                    })
            }
        }

    }
}