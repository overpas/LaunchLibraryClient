package by.overpass.soraac.ui.main.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.View
import by.overpass.soraac.R
import by.overpass.soraac.data.network.status.Status
import by.overpass.soraac.data.network.status.StatusLiveData
import by.overpass.soraac.ui.base.activity.BaseNavigationActivity
import by.overpass.soraac.utils.shortSnackBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseNavigationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusLiveData.observe(this, Observer {
            if (it != null) {
                setNetworkStatus(it)
            }
        })
    }

    override fun getFragmentContainerId() = R.id.flMainFragmentContainer

    override fun getActivityLayoutId() = R.layout.activity_main

    private fun setNetworkStatus(status: Status) {
        if (status == Status.ERROR) {
            spbLoading.shortSnackBar(R.string.network_error_message)
        }
        spbLoading.visibility = when (status) {
            Status.LOADED -> View.GONE
            Status.ERROR -> View.GONE
            Status.LOADING -> View.VISIBLE
        }
    }

}
