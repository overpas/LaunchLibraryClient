package by.overpass.soraac.ui.base.activity

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import by.overpass.soraac.ui.base.fragment.BaseItemFragment
import by.overpass.soraac.utils.replaceFragment

abstract class BaseItemActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun getActivityLayoutId(): Int

    @IdRes
    abstract fun getFragmentContainerId(): Int

    abstract fun getSelectedItemIdKey(): String

    abstract fun getItemFragment(): BaseItemFragment

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityLayoutId())
        val itemId = intent.extras?.getInt(getSelectedItemIdKey())
        if (savedInstanceState == null && itemId != null) {
            val itemFragment = getItemFragment().also { itemFragment ->
                itemFragment.arguments = Bundle().also { it.putInt(getSelectedItemIdKey(), itemId) }
            }
            replaceFragment(getFragmentContainerId(), itemFragment, false)
        }
    }

}