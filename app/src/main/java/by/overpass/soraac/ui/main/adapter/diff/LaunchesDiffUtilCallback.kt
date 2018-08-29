package by.overpass.soraac.ui.main.adapter.diff

import android.support.v7.util.DiffUtil
import by.overpass.soraac.data.model.pojo.db.Launch

class LaunchesDiffUtilCallback(
        private val oldList: List<Launch>,
        private val newList: List<Launch>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemIndex: Int, newItemIndex: Int) =
            oldList[oldItemIndex].id!! == newList[newItemIndex].id!!

    override fun areContentsTheSame(oldItemIndex: Int, newItemIndex: Int) =
            oldList[oldItemIndex] == newList[newItemIndex]

}