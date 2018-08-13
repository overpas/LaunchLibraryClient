package by.overpass.soraac.ui

import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast

fun View.shortToast(@StringRes stringResId: Int) {
    Toast
            .makeText(this.context, stringResId, Toast.LENGTH_SHORT)
            .show()
}

fun View.shortToast(message: String) {
    Toast
            .makeText(this.context, message, Toast.LENGTH_SHORT)
            .show()
}

fun View.longToast(@StringRes stringResId: Int) {
    Toast
            .makeText(this.context, stringResId, Toast.LENGTH_LONG)
            .show()
}

fun View.longToast(message: String) {
    Toast
            .makeText(this.context, message, Toast.LENGTH_LONG)
            .show()
}

fun View.shortSnackBar(@StringRes stringResId: Int) {
    Snackbar
            .make(this, stringResId, Snackbar.LENGTH_SHORT)
            .show()
}

fun View.shortSnackBar(message: String) {
    Snackbar
            .make(this, message, Toast.LENGTH_SHORT)
            .show()
}

fun View.longSnackBar(@StringRes stringResId: Int) {
    Snackbar
            .make(this, stringResId, Snackbar.LENGTH_LONG)
            .show()
}

fun View.longSnackBar(message: String) {
    Snackbar
            .make(this, message, Toast.LENGTH_LONG)
            .show()
}