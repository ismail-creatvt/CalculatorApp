package com.ismail.creatvt.mytodoapp

import android.view.View
import android.widget.TextView

fun View.getText(): String {
    if(this is TextView) {
        return text.toString()
    }
    return ""
}

fun String.replaceDisplayOperatorsToMathOperators(): String {
    return replace('÷', '/')
        .replace('×', '*')
        .replace('−', '-')// they look exacly the same here but in display the first - is a little different
}

fun Char.isAnOperation(): Boolean {
    return arrayOf('+', '−', '×', '÷').contains(this)
}

fun String.lastCharacter():Char {
    return get(length - 1)
}

fun String.removeLastCharacterIfItIsOperator(): String {
    val lastValue = lastCharacter()
    if (lastValue.isAnOperation()) {
        return removeLastCharacter()
    }
    return this
}

fun String.removeLastCharacter(): String {
    return substring(0, length - 1)
}