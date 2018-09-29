package by.overpass.soraac.ui.main.fragment


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.fragment.BaseItemsFragment
import by.overpass.soraac.ui.main.adapter.LaunchesAdapter
import by.overpass.soraac.viewmodel.launch.LaunchViewModel
import kotlinx.android.synthetic.main.fragment_launches.*

class LaunchesFragment : BaseItemsFragment() {

    override fun getLayoutId() = R.layout.fragment_launches

    override fun getToolbar(): Toolbar = toolbar

    private lateinit var launchViewModel: LaunchViewModel
    private lateinit var launchesAdapter: LaunchesAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvLaunchList.layoutManager = LinearLayoutManager(context)
        launchesAdapter = LaunchesAdapter()
        rvLaunchList.adapter = launchesAdapter
        launchViewModel = LaunchViewModel.Factory.get(this)
        launchViewModel.launches.observe(this, Observer { list ->
            list?.let {
                launchesAdapter.launches = it
            }
        })
    }
}
