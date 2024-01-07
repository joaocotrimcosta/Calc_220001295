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
        val val_number1 = state.val_number1.toDoubleOrNull()
        val val_number2 = state.val_number2.toDoubleOrNull()
        if(val_number1 != null && val_number2 != null) {
            val result = when(state.operation) {
                is COperation.Add -> val_number1 + val_number2
                is COperation.Subtract -> val_number1 - val_number2
                is COperation.Multiply -> val_number1 * val_number2
                is COperation.Divide -> val_number1 / val_number2
                is COperation.Percentage -> val_number1 % val_number2
                null -> return
            }
            state = state.copy(
                val_number1 = result.toString(),//.take(15),
                val_number2 = "",
                operation = null
            )
        }

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

