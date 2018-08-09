package by.overpass.soraac.ui.main.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.R
import by.overpass.soraac.ui.main.adapter.StubRvAdapter
import kotlinx.android.synthetic.main.fragment_launches.*

class LaunchesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_launches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvEventsList.layoutManager = LinearLayoutManager(context)
        rvEventsList.adapter = StubRvAdapter()
    }
}
