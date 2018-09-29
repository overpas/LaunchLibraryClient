package by.overpass.soraac.ui.base.listener

import android.content.Intent
import android.view.View
import by.overpass.soraac.ui.base.activity.BaseItemActivity

abstract class BaseItemClickListener<T : BaseItemActivity>(private val itemId: Int)
    : View.OnClickListener {

    abstract fun getItemKey(): String
    abstract fun getItemActivityClass(): Class<T>

    override fun onClick(view: View?) {
        view?.context?.let {
            val intent = Intent(it, getItemActivityClass())
            intent.putExtra(getItemKey(), itemId)
            it.startActivity(intent)
        }
    }

}