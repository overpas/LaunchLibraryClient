package by.overpass.soraac.ui

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

fun Fragment.setHostActivityToolbar(toolbar: Toolbar) {
    activity?.let {
        val activity = it as AppCompatActivity
        activity.setSupportActionBar(toolbar)
    }
}