package com.jotap.calc_220001295.Calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CViewModel : ViewModel() {
    var state by mutableStateOf(CState())
        private set

    fun onAction(action: CAction) {
        when (action) {
            is CAction.Number -> enterNumber(action.number)
            is CAction.Decimal -> enterDecimal()
            is CAction.Clear -> state = CState()
            is CAction.Operation -> enterOperation(action.operation)
            is CAction.Calculate -> performCalculation()
            is CAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.val_number2.isNotBlank() -> state =
                state.copy(val_number2 = state.val_number2.dropLast(1))

            state.operation != null -> state = state.copy(operation = null)
            state.val_number1.isNotBlank() -> state =
                state.copy(val_number1 = state.val_number2.dropLast(1))
        }
    }

    private fun performCalculation() {

    }

    private fun enterOperation(operation: COperation) {
        if (state.val_number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.val_number1.contains(".") && state.val_number1.isNotBlank()) {
            state = state.copy(
                val_number1 = state.val_number1 + "."
            )
            return
        }
        if (state.operation == null && !state.val_number2.contains(".") && state.val_number2.isNotBlank()) {
            state = state.copy(
                val_number1 = state.val_number2 + "."
            )
            return
        }

    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.val_number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(val_number1 = state.val_number1 + number)
            return
        }
        if (state.val_number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(val_number2 = state.val_number2 + number)
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}

