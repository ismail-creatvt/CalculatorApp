package com.ismail.creatvt.mytodoapp

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.jarvisjin.finexpr.expr.Expression

class MainViewModel : ViewModel() {

    private val _outputText = MutableLiveData("0")
    val outputText: LiveData<String>
        get() = _outputText


    fun onBackspaceClick(view: View) {
        var value = getValueOnDisplay()
        if (value.isNotEmpty()) {
            value = value.removeLastCharacter()
            if(value.isEmpty())
                value = "0"
            _outputText.value = value
        }
    }

    fun onNumberClick(view: View) {
        val number = view.getText()
        val outputTextValue = getValueOnDisplay()
        _outputText.value = outputTextValue + number
    }

    fun onOperatorClick(view: View) {
        val value = view.getText()
        val outputTextValue = getValueOnDisplay()

        if (outputTextValue.isNotEmpty()) {
            _outputText.value = outputTextValue.removeLastCharacterIfItIsOperator() + value
        }
    }

    private fun getValueOnDisplay(): String {
        val value = _outputText.value ?: ""
        return if(value == "0") "" else value
    }

    fun onClearClick(view: View?) {
        _outputText.value = "0"
    }

    fun onEqualsClick(view: View?) {
        val outputTextValue = getValueOnDisplay()
            .removeLastCharacterIfItIsOperator()
            .replaceDisplayOperatorsToMathOperators()
        val e = Expression(outputTextValue)
        val result = e.calculate()
        _outputText.value = String.format("%.2f", result)
    }
}
