package by.overpass.soraac.ui.main.listener

import by.overpass.soraac.MISSION_ID_KEY
import by.overpass.soraac.ui.base.listener.BaseItemClickListener
import by.overpass.soraac.ui.mission.activity.MissionActivity

class OnMissionClickListener(missionId: Int)
    : BaseItemClickListener<MissionActivity>(missionId) {

    override fun getItemKey(): String = MISSION_ID_KEY

    override fun getItemActivityClass() = MissionActivity::class.java


}