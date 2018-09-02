package by.overpass.soraac.ui

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

fun AppCompatActivity.addFragment(@IdRes containerId: Int, fragment: Fragment, toBackStack: Boolean) {
    if (toBackStack) {
        supportFragmentManager
                .beginTransaction()
                .add(containerId, fragment, fragment.simpleName)
                .addToBackStack(null)
                .commit()
    } else {
        supportFragmentManager
                .beginTransaction()
                .add(containerId, fragment, fragment.simpleName)
                .commit()
    }
}

fun AppCompatActivity.replaceFragment(@IdRes containerId: Int, fragment: Fragment, toBackStack: Boolean) {
    if (toBackStack) {
        supportFragmentManager
                .beginTransaction()
                .replace(containerId, fragment, fragment.simpleName)
                .addToBackStack(null)
                .commit()
    } else {
        supportFragmentManager
                .beginTransaction()
                .replace(containerId, fragment, fragment.simpleName)
                .commit()
    }
}

fun AppCompatActivity.addFragmentAndHidePrevious(@IdRes containerId: Int, fragment: Fragment, toBackStack: Boolean) {
    val previousFragment = supportFragmentManager.findFragmentById(containerId)
    if (toBackStack) {
        if (previousFragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .hide(previousFragment)
                    .add(containerId, fragment, fragment.simpleName)
                    .addToBackStack(null)
                    .commit()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .add(containerId, fragment, fragment.simpleName)
                    .addToBackStack(null)
                    .commit()
        }
    } else {
        if (previousFragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .hide(previousFragment)
                    .add(containerId, fragment, fragment.simpleName)
                    .commit()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .add(containerId, fragment, fragment.simpleName)
                    .commit()
        }
    }
}