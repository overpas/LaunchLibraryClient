package by.overpass.soraac.ui.rocket

import android.content.Intent
import android.net.Uri
import android.view.View
import by.overpass.soraac.R
import by.overpass.soraac.utils.shortSnackBar

class RocketWikiOpener(val view: View) {
    fun open(wikiUrl: String?) {
        view.context?.let {
            if (wikiUrl == null) {
                view.shortSnackBar(R.string.message_no_wiki)
            } else {
                it.startActivity(
                        Intent(Intent.ACTION_VIEW, Uri.parse(wikiUrl))
                )
            }
        }
    }
}