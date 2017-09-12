package development.alberto.com.flickrtest.presentation.presenter

import android.widget.EditText

/**
 * Created by alber on 12/09/2017.
 */

interface Presenter {
    fun onCreate()
    fun onResume()
    fun onPause()
    fun onDestroy()
    //other functions
    fun sendUserText(trim: EditText)
}