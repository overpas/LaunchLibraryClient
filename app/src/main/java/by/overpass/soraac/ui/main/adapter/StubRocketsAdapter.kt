package by.overpass.soraac.ui.main.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.overpass.soraac.R
import by.overpass.soraac.data.model.pojo.db.Rocket
import by.overpass.soraac.databinding.ItemRocketBinding
import by.overpass.soraac.ui.main.adapter.diff.RocketsDiffUtilCallback
import by.overpass.soraac.ui.rocket.RocketWikiOpener

class StubRocketsAdapter : RecyclerView.Adapter<StubRocketsAdapter.RocketViewHolder>() {

    var rockets: List<Rocket> = arrayListOf()
        set(value) {
            val diffCallback = RocketsDiffUtilCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RocketViewHolder {
        return RocketViewHolder(
                ItemRocketBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun getItemCount() = rockets.size

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        holder.binding.rocket = rockets[position]
        holder.binding.rocketWikiOpener = RocketWikiOpener(
                holder.itemView.findViewById(R.id.tvRocketName)
        )
    }


    class RocketViewHolder(val binding: ItemRocketBinding) : RecyclerView.ViewHolder(binding.root)

}