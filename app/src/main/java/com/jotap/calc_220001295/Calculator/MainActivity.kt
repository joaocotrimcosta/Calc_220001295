package com.jotap.calc_220001295.Calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jotap.calc_220001295.ui.theme.Calc_220001295Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calc_220001295Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StartYourEngine()
                }
            }
        }
    }
}


@Preview
@Composable
fun StartYourEngine() {
    val viewModel = viewModel<CViewModel>()
    val state = viewModel.state
    val buttonSpacing = 7.dp
    CFrontEnd(state = viewModel.state, onAction = (CAction) -> Unit)
}