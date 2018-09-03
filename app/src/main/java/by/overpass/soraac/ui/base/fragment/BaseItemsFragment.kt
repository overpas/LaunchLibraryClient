package by.overpass.soraac.ui.base.fragment

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.utils.setHostActivityToolbar

abstract class BaseItemsFragment : Fragment() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getToolbar(): Toolbar

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        setHostActivityToolbar(getToolbar())
    }

}