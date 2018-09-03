package by.overpass.soraac.ui.base.activity

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import by.overpass.soraac.R
import by.overpass.soraac.ui.main.fragment.LaunchesFragment
import by.overpass.soraac.ui.main.fragment.MissionsFragment
import by.overpass.soraac.ui.main.fragment.RocketsFragment
import by.overpass.soraac.ui.main.fragment.SettingsFragment
import by.overpass.soraac.utils.simpleName
import by.overpass.soraac.utils.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

abstract class BaseNavigationActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val fragmentNamesStack: Stack<String> = Stack()

    init {
        fragmentNamesStack.push(LaunchesFragment::class.java.simpleName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayoutId())
        if (savedInstanceState == null) {
            replaceFragment(getFragmentContainerId(), LaunchesFragment(), false)
        }
        bnvBottomMenu.setOnNavigationItemSelectedListener(this)
    }

    @IdRes
    protected abstract fun getFragmentContainerId(): Int

    @LayoutRes
    protected abstract fun getActivityLayoutId(): Int

    private fun switchTo(fragment: Fragment) {
        if (fragmentNamesStack.isEmpty() || fragment.simpleName == fragmentNamesStack.peek()) {
            return
        }
        val transaction = supportFragmentManager.beginTransaction()
        val topFragment = supportFragmentManager.findFragmentByTag(fragmentNamesStack.peek())
        if (topFragment != null) {
            transaction.hide(topFragment)
        }
        val existingFragment = supportFragmentManager.findFragmentByTag(fragment.simpleName)
        if (existingFragment != null) {
            transaction
                    .show(existingFragment)
                    .addToBackStack(null)
        } else {
            transaction
                    .add(getFragmentContainerId(), fragment, fragment.simpleName)
                    .addToBackStack(null)
        }
        transaction.commit()
        fragmentNamesStack.push(fragment.simpleName)
        setBottomMenuSelectedItem()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        switchTo(when (menuItem.itemId) {
            R.id.action_missions -> MissionsFragment()
            R.id.action_rockets -> RocketsFragment()
            R.id.action_settings -> SettingsFragment()
            else -> LaunchesFragment()
        })
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (fragmentNamesStack.isNotEmpty()) {
            fragmentNamesStack.pop()
            setBottomMenuSelectedItem()
        }
    }

    private fun setBottomMenuSelectedItem() {
        if (fragmentNamesStack.isEmpty()) {
            bnvBottomMenu.selectedItemId = R.id.action_launches
        } else {
            bnvBottomMenu.selectedItemId = when (fragmentNamesStack.peek()) {
                RocketsFragment::class.java.simpleName -> R.id.action_rockets
                MissionsFragment::class.java.simpleName -> R.id.action_missions
                SettingsFragment::class.java.simpleName -> R.id.action_settings
                else -> R.id.action_launches
            }
        }
    }

}