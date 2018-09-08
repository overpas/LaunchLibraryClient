package by.overpass.soraac.ui.main.listener

import android.content.Intent
import android.view.View
import by.overpass.soraac.MISSION_ID_KEY
import by.overpass.soraac.ui.mission.activity.MissionActivity

class OnMissionClickListener(private val missionId: Int) : View.OnClickListener {

    override fun onClick(view: View?) {
        view?.context?.let {
            val intent = Intent(it, MissionActivity::class.java)
            intent.putExtra(MISSION_ID_KEY, missionId)
            it.startActivity(intent)
        }
    }

}