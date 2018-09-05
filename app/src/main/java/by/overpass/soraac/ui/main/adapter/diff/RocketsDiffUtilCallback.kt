package by.overpass.soraac.ui.main.adapter.diff

import android.support.v7.util.DiffUtil
import by.overpass.soraac.data.model.pojo.db.Rocket

class RocketsDiffUtilCallback(
        private val oldList: List<Rocket>,
        private val newList: List<Rocket>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemIndex: Int, newItemIndex: Int) =
            oldList[oldItemIndex] == newList[newItemIndex]

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemIndex: Int, newItemIndex: Int) =
            oldList[oldItemIndex].id!! == newList[newItemIndex].id!!
    
}