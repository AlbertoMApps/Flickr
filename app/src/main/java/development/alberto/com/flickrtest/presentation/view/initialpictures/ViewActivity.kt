package development.alberto.com.flickrtest.presentation.view.initialpictures

import android.widget.EditText
import development.alberto.com.flickrtest.data.model.Item

/**
 * Created by alber on 12/09/2017.
 */
  interface ViewActivity {
    fun showError(s: String)
    fun showPicturesInList(items: List<Item>?)
    fun getEditText(): EditText?
}