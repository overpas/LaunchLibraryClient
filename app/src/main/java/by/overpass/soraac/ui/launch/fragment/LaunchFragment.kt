package by.overpass.soraac.ui.launch.fragment


import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.LAUNCH_ID_KEY
import by.overpass.soraac.R
import by.overpass.soraac.databinding.FragmentLaunchBinding
import by.overpass.soraac.ui.base.fragment.BaseItemFragment
import by.overpass.soraac.viewmodel.ViewModelFactory
import by.overpass.soraac.viewmodel.launch.LaunchViewModel

class LaunchFragment : BaseItemFragment() {

    private lateinit var launchViewModel: LaunchViewModel
    private lateinit var binding: FragmentLaunchBinding

    override fun getFragmentLayoutId() = R.layout.fragment_launch

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentLaunchBinding.inflate(LayoutInflater.from(context), container, false)
        binding.setLifecycleOwner(this)
        launchViewModel = ViewModelFactory.Launch.get(this)
        arguments?.getInt(LAUNCH_ID_KEY)?.let { launchId ->
            launchViewModel.getById(launchId).observe(this, Observer { launch ->
                Log.i(this@LaunchFragment::class.java.simpleName, "OBSERVE!")
                launch?.let { binding.launch = it }
            })
        }
        return binding.root
    }

}
