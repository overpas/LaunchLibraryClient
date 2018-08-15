package by.overpass.soraac.ui.launch.fragment


import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import by.overpass.soraac.R
import kotlinx.android.synthetic.main.fragment_launch.*

class LaunchFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_launch, container, false)
    }

    @SuppressLint("RestrictedApi")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.let {
            val activity = it as AppCompatActivity
            activity.setSupportActionBar(toolbar)
            activity.supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        }
    }
}
