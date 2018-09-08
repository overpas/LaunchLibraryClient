package by.overpass.soraac.ui.mission.fragment


import android.arch.lifecycle.Observer
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.overpass.soraac.DEFAULT_WIKI_LINK
import by.overpass.soraac.MISSION_ID_KEY
import by.overpass.soraac.R
import by.overpass.soraac.databinding.FragmentMissionBinding
import by.overpass.soraac.ui.base.fragment.BaseItemFragment
import by.overpass.soraac.viewmodel.mission.MissionViewModel
import kotlinx.android.synthetic.main.fragment_mission.*

class MissionFragment : BaseItemFragment() {

    private lateinit var missionViewModel: MissionViewModel
    private lateinit var binding: FragmentMissionBinding

    override fun getFragmentLayoutId() = R.layout.fragment_mission

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMissionBinding.inflate(LayoutInflater.from(context), container, false)
        binding.setLifecycleOwner(this)
        missionViewModel = MissionViewModel.Factory.get(this)
        arguments?.getInt(MISSION_ID_KEY)?.let { missionId ->
            missionViewModel.getById(missionId).observe(this, Observer { mission ->
                mission?.let { binding.mission = it }
            })
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvMissionWikiUrl.paintFlags = tvMissionWikiUrl.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.missionWikiOpener = MissionWikiOpener(tvMissionWikiUrl)
    }

    class MissionWikiOpener(private val view: View) {
        fun open(wikiUrl: String?) {
            view.context?.startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(wikiUrl ?: DEFAULT_WIKI_LINK))
            )
        }
    }

}
