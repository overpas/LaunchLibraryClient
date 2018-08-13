package by.overpass.soraac.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import by.overpass.soraac.databinding.ItemLaunchBinding
import by.overpass.soraac.model.pojo.db.Launch


class StubRvAdapter() : RecyclerView.Adapter<StubRvAdapter.StubViewHolder>() {

    var launches: List<Launch> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StubViewHolder {
        return StubViewHolder(
                ItemLaunchBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                )
        )
    }

    override fun getItemCount() = launches.size

    override fun onBindViewHolder(holder: StubViewHolder, position: Int) {
        holder.binding.launch = launches[position]
    }

    class StubViewHolder(val binding: ItemLaunchBinding) : RecyclerView.ViewHolder(binding.root)

}