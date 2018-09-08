package by.overpass.soraac.ui.mission.activity

import by.overpass.soraac.MISSION_ID_KEY
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.activity.BaseItemActivity
import by.overpass.soraac.ui.base.fragment.BaseItemFragment
import by.overpass.soraac.ui.main.fragment.MissionsFragment
import by.overpass.soraac.ui.mission.fragment.MissionFragment

class MissionActivity : BaseItemActivity() {

    override fun getActivityLayoutId() = R.layout.activity_mission

    override fun getFragmentContainerId() = R.id.flMissionFragmentContainer

    override fun getSelectedItemIdKey() = MISSION_ID_KEY

    override fun getItemFragment() = MissionFragment()

}
