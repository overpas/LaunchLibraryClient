package by.overpass.soraac.ui.main.fragment


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.R
import by.overpass.soraac.ui.main.adapter.StubRvAdapter
import by.overpass.soraac.viewmodel.launch.LaunchViewModel
import by.overpass.soraac.viewmodel.launch.LaunchViewModelFactory
import kotlinx.android.synthetic.main.fragment_launches.*

class LaunchesFragment : Fragment() {

    private lateinit var launchViewModel: LaunchViewModel
    private lateinit var rvLaunchesAdapter: StubRvAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_launches, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        activity?.let {
            val activity = it as AppCompatActivity
            activity.setSupportActionBar(toolbar)
        }
        rvLaunchList.layoutManager = LinearLayoutManager(context)
        rvLaunchesAdapter = StubRvAdapter()
        rvLaunchList.adapter = rvLaunchesAdapter
        launchViewModel = LaunchViewModelFactory.createStub(this)
        launchViewModel.launches.observe(this, Observer { it ->
            it?.let { rvLaunchesAdapter.launches = it }
        })
    }
}
