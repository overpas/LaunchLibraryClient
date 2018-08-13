package by.overpass.soraac.ui

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.addFragment(@IdRes containerId: Int, fragment: Fragment, toBackStack: Boolean) {
    if (toBackStack) {
        supportFragmentManager
                .beginTransaction()
                .add(containerId, fragment)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    } else {
        supportFragmentManager
                .beginTransaction()
                .add(containerId, fragment)
                .commit()
    }
}

fun AppCompatActivity.replaceFragment(@IdRes containerId: Int, fragment: Fragment, toBackStack: Boolean) {
    if (toBackStack) {
        supportFragmentManager
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    } else {
        supportFragmentManager
                .beginTransaction()
                .replace(containerId, fragment)
                .commit()
    }
}