package by.overpass.soraac.ui.base.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.R
import by.overpass.soraac.ui.setHostActivityToolbar

abstract class BaseItemFragment : Fragment() {

    private val toolbar: Toolbar? by lazy {
        return@lazy this@BaseItemFragment.activity?.findViewById<Toolbar>(R.id.toolbar)
    }

    @LayoutRes
    abstract fun getFragmentLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getFragmentLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        toolbar?.apply {
            this.setNavigationIcon(R.drawable.ic_arrow_left)
            setHostActivityToolbar(this)
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