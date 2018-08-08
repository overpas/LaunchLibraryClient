package by.overpass.soraac.ui.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StubRvAdapter() : RecyclerView.Adapter<StubRvAdapter.StubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StubViewHolder {
        return StubViewHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(android.R.layout.simple_list_item_1, parent, false)
        )
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: StubViewHolder, position: Int) {
        (holder.itemView as TextView).text = position.toString()
    }

    class StubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}