package by.overpass.soraac.ui.main.activity

import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.activity.BaseNavigationActivity
import by.overpass.soraac.utils.shortToast

class MainActivity : BaseNavigationActivity() {

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
}
