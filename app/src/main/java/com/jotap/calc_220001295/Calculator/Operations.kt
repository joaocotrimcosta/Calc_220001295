package com.jotap.calc_220001295.Calculator

sealed class COperation (val symbol: String){

    object Add: COperation("+")
    object Subtract: COperation("-")
    object Multiply: COperation("*")
    object Divide: COperation("/")
    object Percentage: COperation("%")

    }
