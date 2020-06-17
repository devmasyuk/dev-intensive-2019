package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.inputmethodservice.InputMethodService
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard(){
    val view = currentFocus ?: return
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}
