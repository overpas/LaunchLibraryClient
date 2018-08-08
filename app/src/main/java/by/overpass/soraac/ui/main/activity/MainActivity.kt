package by.overpass.soraac.ui.main.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.overpass.soraac.R
import by.overpass.soraac.extensions.replaceFragment
import by.overpass.soraac.ui.main.fragment.EventsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceFragment(R.id.flMainFragmentContainer, EventsFragment(), false)
        }
    }

}
