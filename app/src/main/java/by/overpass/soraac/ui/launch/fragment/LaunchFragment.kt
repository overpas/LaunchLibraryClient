package by.overpass.soraac.ui.launch.fragment


import android.arch.lifecycle.Observer
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.DEFAULT_MAP_LINK
import by.overpass.soraac.LAUNCH_ID_KEY
import by.overpass.soraac.R
import by.overpass.soraac.databinding.FragmentLaunchBinding
import by.overpass.soraac.ui.base.fragment.BaseItemFragment
import by.overpass.soraac.viewmodel.launch.LaunchViewModel
import kotlinx.android.synthetic.main.fragment_launch.*

class LaunchFragment : BaseItemFragment() {

    private lateinit var launchViewModel: LaunchViewModel
    private lateinit var binding: FragmentLaunchBinding

    override fun getFragmentLayoutId() = R.layout.fragment_launch

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLaunchBinding.inflate(LayoutInflater.from(context), container, false)
        binding.setLifecycleOwner(this)
        launchViewModel = LaunchViewModel.Factory.get(this)
        arguments?.getInt(LAUNCH_ID_KEY)?.let { launchId ->
            launchViewModel.getById(launchId).observe(this, Observer { launch ->
                Log.i(this@LaunchFragment::class.java.simpleName, "OBSERVE!")
                launch?.let { binding.launch = it }
            })
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvLocation.paintFlags = tvLocation.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.mapOpener = MapOpener(tvLocation)
    }

    class MapOpener(private val view: View) {
        fun open(mapLink: String?) {
            view.context?.startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(mapLink ?: DEFAULT_MAP_LINK))
            )
        }
    }

}
