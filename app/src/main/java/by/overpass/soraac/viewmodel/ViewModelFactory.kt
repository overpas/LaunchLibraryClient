package by.overpass.soraac.viewmodel

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment

abstract class ViewModelFactory {
    abstract fun get(fragment: Fragment): ViewModel
}