package by.overpass.soraac.ui.main.fragment


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.fragment.BaseItemsFragment
import by.overpass.soraac.ui.main.adapter.StubMissionsAdapter
import by.overpass.soraac.viewmodel.mission.MissionViewModel
import kotlinx.android.synthetic.main.fragment_missions.*

class MissionsFragment : BaseItemsFragment() {

    override fun getLayoutId() = R.layout.fragment_missions

    override fun getToolbar(): Toolbar = toolbar

    private lateinit var missionsViewModel: MissionViewModel
    private lateinit var missionsAdapter: StubMissionsAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvMissionsList.layoutManager = LinearLayoutManager(context)
        missionsAdapter = StubMissionsAdapter()
        rvMissionsList.adapter = missionsAdapter
        missionsViewModel = MissionViewModel.Factory.get(this)
        missionsViewModel.missions.observe(this, Observer { missions ->
            missions?.let { missionsAdapter.missions = it }
        })
    }
}
