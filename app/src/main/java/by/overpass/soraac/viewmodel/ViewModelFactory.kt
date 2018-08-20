package by.overpass.soraac.viewmodel

class ViewModelFactory private constructor() {

    // TODO
    /*fun <T : ViewModel> of(theClass: Class<T>) = when (theClass) {

    }*/

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance() = instance ?: synchronized(ViewModelFactory::class.java) {
            instance ?: ViewModelFactory().also { instance = it }
        }
    }

}