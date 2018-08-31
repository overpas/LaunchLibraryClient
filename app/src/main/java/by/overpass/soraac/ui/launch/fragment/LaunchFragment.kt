package by.overpass.soraac.ui.launch.fragment


import android.arch.lifecycle.Observer
import android.os.Bundle
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.fragment.BaseItemFragment
import by.overpass.soraac.viewmodel.ViewModelFactory
import by.overpass.soraac.viewmodel.launch.LaunchViewModel

class LaunchFragment : BaseItemFragment() {

    private lateinit var launchViewModel: LaunchViewModel

    override fun getFragmentLayoutId() = R.layout.fragment_launch

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        launchViewModel = ViewModelFactory.Launch.get(this)
        launchViewModel.launches.observe(this, Observer { it ->

        })
    }
}
