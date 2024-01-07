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
            is CAction.Clear -> state = CState(clearFields = false)
            is CAction.Operation -> enterOperation(action.operation)
            is CAction.Calculate -> performCalculation()
            is CAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.valueNumber2.isNotBlank() ->
                state = state.copy(valueNumber2 = state.valueNumber2.dropLast(1))

            state.operation != null -> state = state.copy(operation = null)

            state.valueNumber1.isNotBlank() ->
                state = state.copy(valueNumber1 = state.valueNumber1.dropLast(1))
        }
    }

    private fun performCalculation() {
        val valueNumber1 = state.valueNumber1.toDoubleOrNull()
        val valueNumber2 = state.valueNumber2.toDoubleOrNull()
        if (valueNumber1 != null && valueNumber2 != null) {
            val result = when (state.operation) {
                is COperation.Add -> valueNumber1 + valueNumber2
                is COperation.Subtract -> valueNumber1 - valueNumber2
                is COperation.Multiply -> valueNumber1 * valueNumber2
                is COperation.Divide -> valueNumber1 / valueNumber2
                is COperation.Percentage -> (valueNumber1 * valueNumber2 / 100)
                null -> return
            }
            state = state.copy(
                valueNumber1 = result.toString(),
                valueNumber2 = "",
                operation = null,
                clearFields = true
            )
            /*
            state = state.copy(
                valueNumber1 = "",
                valueNumber2 = "",
                operation = null
            )
           */
        }
    }

    private fun enterOperation(operation: COperation) {
        if (state.valueNumber1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.valueNumber1.contains(".") && state.valueNumber1.isNotBlank()) {
            state = state.copy(
                valueNumber1 = state.valueNumber1 + "."
            )
            return
        }
        if (state.operation == null && !state.valueNumber2.contains(".") && state.valueNumber2.isNotBlank()) {
            state = state.copy(
                valueNumber2 = state.valueNumber2 + "."
            )
            return
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.valueNumber1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(valueNumber1 = state.valueNumber1 + number)
            return
        }
        if (state.valueNumber2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(valueNumber2 = state.valueNumber2 + number)
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

    private fun checkEquals () {
        if (state.clearFields) {
            onAction(CAction.Clear)
        }
    }
}
