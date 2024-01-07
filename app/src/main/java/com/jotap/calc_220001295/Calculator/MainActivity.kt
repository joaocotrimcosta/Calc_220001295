package com.jotap.calc_220001295.Calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jotap.calc_220001295.ui.theme.Calc_220001295Theme
import com.jotap.calc_220001295.ui.theme.MyBlue2


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calc_220001295Theme {
                StartYourEngine()
            }
        }
    }
}


@Preview
@Composable
fun StartYourEngine() {
    val viewModel = viewModel<CViewModel>()
    val state = viewModel.state
    val buttonSpacing = 8.dp
    CFrontEnd(
        state = state,
        onAction = viewModel::onAction,
        buttonSpacing = buttonSpacing,
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
            .background(color = MyBlue2)
    )
}