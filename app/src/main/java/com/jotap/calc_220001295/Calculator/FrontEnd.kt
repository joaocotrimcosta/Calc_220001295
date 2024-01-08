package com.jotap.calc_220001295.Calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jotap.calc_220001295.R
import com.jotap.calc_220001295.ui.theme.MyBlue1
import com.jotap.calc_220001295.ui.theme.MyBlue3
import com.jotap.calc_220001295.ui.theme.MyBlue4


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CFrontEnd(

    state: CState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: CAction.() -> Unit

) {
    Box(
        modifier = modifier
            .padding(16.dp)
    ) {
        Column(

            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.theBest),
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MyBlue4,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MyBlue3,
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = state.valueNumber1 + (state.operation?.symbol ?: "") + state.valueNumber2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(vertical = 5.dp),
                fontSize = 70.sp,
                color = Color.White,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                    CButton(symbol = "AC",
                    modifier = Modifier
                        .background(MyBlue4)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        CAction.Clear.onAction()
                    })
                CButton(symbol = "Del",
                    modifier = Modifier
                        .background(MyBlue4)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        CAction.Delete.onAction()
                    })
                CButton(symbol = "%",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        CAction.Operation(COperation.Percentage).onAction()
                    })
                CButton(symbol = "/",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        CAction.Operation(COperation.Divide).onAction()
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CButton(symbol = "7",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(7).onAction()
                        } else
                            CAction.Number(7).onAction()
                    })
                CButton(symbol = "8",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(8).onAction()
                        } else
                            CAction.Number(8).onAction()

                    })
                CButton(symbol = "9",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(9).onAction()
                        } else
                            CAction.Number(9).onAction()


                    })
                CButton(symbol = "*",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        CAction.Operation(COperation.Multiply).onAction()
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CButton(symbol = "4",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(4).onAction()
                        } else
                            CAction.Number(4).onAction()
                    })
                CButton(symbol = "5",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(5).onAction()
                        } else
                            CAction.Number(5).onAction()
                    })
                CButton(symbol = "6",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(6).onAction()
                        } else
                            CAction.Number(6).onAction()
                    })
                CButton(symbol = "-",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        CAction.Operation(COperation.Subtract).onAction()
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CButton(symbol = "1",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(1).onAction()
                        } else
                            CAction.Number(1).onAction()
                    })
                CButton(symbol = "2",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(2).onAction()
                        } else
                            CAction.Number(2).onAction()
                    })
                CButton(symbol = "3",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(3).onAction()
                        } else
                            CAction.Number(3).onAction()
                    })
                CButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(MyBlue1)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    CAction.Operation(COperation.Add).onAction()
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CButton(symbol = "0",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        //viewModel.checkEquals ()
                        if (state.clearFields) {
                            onAction(CAction.Clear)
                            CAction.Number(0).onAction()
                        } else
                            CAction.Number(0).onAction()
                    })
                CButton(symbol = ".",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        CAction.Decimal.onAction()
                    })
                CButton(symbol = "=",
                    modifier = Modifier
                        .background(MyBlue3)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        CAction.Calculate.onAction()
                    })

            }
        }
    }
}