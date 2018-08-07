package by.overpass.soraac.ui.main.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import by.overpass.soraac.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnvBottomMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_events -> Toast
                        .makeText(MainActivity@this, "Events", Toast.LENGTH_SHORT)
                        .show()
                R.id.action_ranking -> Toast
                        .makeText(MainActivity@this, "Ranking", Toast.LENGTH_SHORT)
                        .show()
                R.id.action_settings -> Toast
                        .makeText(MainActivity@this, "Settings", Toast.LENGTH_SHORT)
                        .show()
                else -> throw RuntimeException()
            }
            true
        }
    }
}
