package development.alberto.com.flickrtest.presentation.view.initialpictures

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import development.alberto.com.flickrtest.R
import development.alberto.com.flickrtest.data.model.Item
import development.alberto.com.flickrtest.presentation.adapter.ListPicturesAdapter
import development.alberto.com.flickrtest.presentation.presenter.initialpictures.PresenterMainActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ViewActivity {

    lateinit var presenterMainActivityPictures:PresenterMainActivity
    lateinit var listPicturesAdapter:ListPicturesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listPicturesAdapter = ListPicturesAdapter(this, R.layout.flickr_pics_row)
        picturesListView.setLayoutManager( GridLayoutManager(this, 2) )
        picturesListView.adapter = listPicturesAdapter

        presenterMainActivityPictures = PresenterMainActivity(this)
        presenterMainActivityPictures.sendUserText(etSearch)
    }

    override fun showError(s: String) {
        Snackbar.make(llError, s.toString().trim(), Snackbar.LENGTH_LONG)
                .setAction(s.toString(), null).show()
    }

    override fun showPicturesInList(items: List<Item>?) {
        if (items != null) {
            updateRecyclerListPictures(items)
        }
    }

    private fun updateRecyclerListPictures (imagePictures:List<Item>) {
        println(imagePictures.size)
        listPicturesAdapter.listPictures = imagePictures
//        picturesListView.adapter.notifyDataSetChanged()
        listPicturesAdapter.notifyDataSetChanged()
    }

}
