package by.overpass.soraac.ui.main.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.overpass.soraac.data.model.pojo.db.Mission
import by.overpass.soraac.databinding.ItemMissionBinding
import by.overpass.soraac.ui.main.adapter.diff.MissionsDiffUtilCallback
import by.overpass.soraac.ui.main.listener.OnMissionClickListener

class MissionsAdapter : RecyclerView.Adapter<MissionsAdapter.MissionViewHolder>() {

    var missions: List<Mission> = arrayListOf()
        set(value) {
            val diffUtilCallback = MissionsDiffUtilCallback(field, value)
            val diffResult = DiffUtil.calculateDiff(diffUtilCallback)
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MissionViewHolder {
        return MissionViewHolder(
                ItemMissionBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun getItemCount() = missions.size

    override fun onBindViewHolder(holder: MissionViewHolder, position: Int) {
        holder.binding.mission = missions[position]
        holder.itemView.setOnClickListener(OnMissionClickListener(missions[position].id!!))
    }

    class MissionViewHolder(internal val binding: ItemMissionBinding) : RecyclerView.ViewHolder(binding.root)

}
