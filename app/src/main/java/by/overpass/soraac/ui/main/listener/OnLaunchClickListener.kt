package by.overpass.soraac.ui.main.listener

import by.overpass.soraac.LAUNCH_ID_KEY
import by.overpass.soraac.ui.base.listener.BaseItemClickListener
import by.overpass.soraac.ui.launch.activity.LaunchActivity

class OnLaunchClickListener(launchId: Int) : BaseItemClickListener<LaunchActivity>(launchId) {

    override fun getItemKey(): String = LAUNCH_ID_KEY

    override fun getItemActivityClass() = LaunchActivity::class.java

}