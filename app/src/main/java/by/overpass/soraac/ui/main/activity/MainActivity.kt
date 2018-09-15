package by.overpass.soraac.ui.main.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import by.overpass.soraac.R
import by.overpass.soraac.data.network.status.Status
import by.overpass.soraac.data.network.status.StatusLiveData
import by.overpass.soraac.ui.base.activity.BaseNavigationActivity
import by.overpass.soraac.utils.shortSnackBar
import by.overpass.soraac.utils.shortToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseNavigationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusLiveData.observe(this, Observer {
            if (it != null) {
                if (it == Status.ERROR) {
                    spbLoading.shortSnackBar(R.string.network_error_message)
                }
                setProgressVisible(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // TODO Change all this
        menuInflater.inflate(R.menu.launches_top_menu, menu)
        menu?.let {
            val searchMenuItem: MenuItem = it.findItem(R.id.action_search_launches)
            val searchView = searchMenuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(text: String?): Boolean {
                    searchView.shortToast(text.toString())
                    return true
                }

                override fun onQueryTextChange(text: String?): Boolean = false
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun getFragmentContainerId() = R.id.flMainFragmentContainer

    override fun getActivityLayoutId() = R.layout.activity_main

    private fun setProgressVisible(status: Status) {
        spbLoading.visibility = when (status) {
            Status.LOADED -> View.GONE
            Status.ERROR -> View.GONE
            Status.LOADING -> View.VISIBLE
        }
    }

}
