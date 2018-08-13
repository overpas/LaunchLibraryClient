package by.overpass.soraac.ui.main.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import by.overpass.soraac.R
import by.overpass.soraac.ui.replaceFragment
import by.overpass.soraac.ui.main.fragment.LaunchesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceFragment(R.id.flMainFragmentContainer, LaunchesFragment(), false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.launches_top_menu, menu)
        menu?.let {
            val searchMenuItem: MenuItem = it.findItem(R.id.action_search_launches)
            val searchView = searchMenuItem.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(text: String?): Boolean = true
                override fun onQueryTextChange(text: String?): Boolean = true
            })
        }
        return super.onCreateOptionsMenu(menu)
    }
}
