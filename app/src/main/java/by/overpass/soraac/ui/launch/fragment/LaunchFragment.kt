package by.overpass.soraac.ui.launch.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.R
import by.overpass.soraac.ui.base.fragment.BaseItemFragment

class LaunchFragment : BaseItemFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_launch, container, false)
    }

}
