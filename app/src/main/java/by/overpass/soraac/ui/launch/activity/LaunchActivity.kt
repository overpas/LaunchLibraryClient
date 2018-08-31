package by.overpass.soraac.ui.launch.activity

import by.overpass.soraac.LAUNCH_ID_KEY
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.activity.BaseItemActivity
import by.overpass.soraac.ui.launch.fragment.LaunchFragment

class LaunchActivity : BaseItemActivity() {

    override fun getActivityLayoutId() = R.layout.activity_launch

    override fun getFragmentContainerId() = R.id.flLaunchFragmentContainer

    override fun getSelectedItemIdKey() = LAUNCH_ID_KEY

    override fun getItemFragment() = LaunchFragment()

}
