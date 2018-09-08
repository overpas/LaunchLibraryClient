package by.overpass.soraac.ui.main.fragment


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.Toolbar
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.fragment.BaseItemsFragment
import by.overpass.soraac.ui.main.adapter.StubRocketsAdapter
import by.overpass.soraac.viewmodel.rocket.RocketViewModel
import kotlinx.android.synthetic.main.fragment_rockets.*

class RocketsFragment : BaseItemsFragment() {

    override fun getLayoutId() = R.layout.fragment_rockets

    override fun getToolbar(): Toolbar = toolbar

    private lateinit var rocketViewModel: RocketViewModel
    private lateinit var rocketsAdapter: StubRocketsAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvRocketList.layoutManager = StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
        )
        rocketsAdapter = StubRocketsAdapter()
        rvRocketList.adapter = rocketsAdapter
        rocketViewModel = RocketViewModel.Factory.get(this)
        rocketViewModel.rockets.observe(this, Observer { rockets ->
            rockets?.let { rocketsAdapter.rockets = it }
        })
    }
}
