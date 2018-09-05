package by.overpass.soraac.ui.main.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.overpass.soraac.databinding.ItemLaunchBinding
import by.overpass.soraac.data.model.pojo.db.Launch
import by.overpass.soraac.ui.main.adapter.diff.LaunchesDiffUtilCallback
import by.overpass.soraac.ui.main.listener.OnLaunchClickListener


class StubLaunchesAdapter : RecyclerView.Adapter<StubLaunchesAdapter.LaunchViewHolder>() {

    var launches: List<Launch> = arrayListOf()
        set(value) {
            val diffUtilCallback = LaunchesDiffUtilCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder(
                ItemLaunchBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun getItemCount() = launches.size

    override fun onBindViewHolder(holderRocket: LaunchViewHolder, position: Int) {
        holderRocket.binding.launch = launches[position]
        holderRocket.itemView.setOnClickListener(OnLaunchClickListener(launches[position].id!!))
    }

    class LaunchViewHolder(val binding: ItemLaunchBinding) : RecyclerView.ViewHolder(binding.root)

}