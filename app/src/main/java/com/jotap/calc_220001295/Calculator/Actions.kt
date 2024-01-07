package com.jotap.calc_220001295.Calculator

sealed class CAction {
    data class Number(val number: Int): CAction()
    object Clear: CAction()
    object Delete: CAction()
    data class Operation(val operation: COperation): CAction()
    object Calculate: CAction()
    object Decimal: CAction()

}
