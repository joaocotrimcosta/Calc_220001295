package com.jotap.calc_220001295.Calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CViewModel: ViewModel(){
    var state by mutableStateOf(CState())
        private set
}
