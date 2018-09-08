package by.overpass.soraac.ui.main.adapter.diff

import android.support.v7.util.DiffUtil
import by.overpass.soraac.data.model.pojo.db.Mission

class MissionsDiffUtilCallback(
        private val oldList: List<Mission>,
        private val newList: List<Mission>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemIndex: Int, newItemIndex: Int) =
            oldList[oldItemIndex] == newList[newItemIndex]

    override fun areContentsTheSame(oldItemIndex: Int, newItemIndex: Int) =
            oldList[oldItemIndex].id == newList[newItemIndex].id

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

}