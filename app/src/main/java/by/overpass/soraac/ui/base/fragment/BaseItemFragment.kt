package by.overpass.soraac.ui.base.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import by.overpass.soraac.R

open class BaseItemFragment : Fragment() {

    private val toolbar: Toolbar? by lazy {
        return@lazy this@BaseItemFragment.activity?.findViewById<Toolbar>(R.id.toolbar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.let {
            val activity = it as AppCompatActivity
            toolbar?.setNavigationIcon(R.drawable.ic_arrow_left)
            activity.setSupportActionBar(toolbar)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            activity?.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}