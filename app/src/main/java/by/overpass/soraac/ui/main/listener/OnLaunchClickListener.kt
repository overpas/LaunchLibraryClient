package by.overpass.soraac.ui.main.listener

import android.content.Intent
import android.view.View
import by.overpass.soraac.LAUNCH_ID_KEY
import by.overpass.soraac.ui.launch.activity.LaunchActivity

class OnLaunchClickListener(private val launchId: Int) : View.OnClickListener {

    override fun onClick(view: View?) {
        view?.context?.let {
            val intent = Intent(it, LaunchActivity::class.java)
            intent.putExtra(LAUNCH_ID_KEY, launchId)
            it.startActivity(intent)
        }
    }

}