package com.jotap.calc_220001295.Calculator

sealed class CAction {
    data class Number (val number: Int): CAction()
    object Clear: CAction()
    object Percentage: CAction()
    object Delete: CAction()
    object Decimal: CAction()
    object Calculate: CAction()
    data class Operation(val operation: COperation): CAction()
}