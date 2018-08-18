package by.overpass.soraac.ui.launch.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import by.overpass.soraac.R
import by.overpass.soraac.ui.launch.fragment.LaunchFragment
import by.overpass.soraac.ui.replaceFragment

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        if (savedInstanceState == null) {
            replaceFragment(R.id.flLaunchFragmentContainer, LaunchFragment(), false)
        }
    }
}
