package development.alberto.com.flickrtest.presentation.presenter.initialpictures

import com.jakewharton.rxbinding2.widget.RxTextView
import development.alberto.com.flickrtest.business.interactor.Interactor
import development.alberto.com.flickrtest.data.datarepository.FlickrRepository
import development.alberto.com.flickrtest.presentation.presenter.Presenter
import development.alberto.com.flickrtest.presentation.view.initialpictures.ViewActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by alber on 12/09/2017.
 */

class PresenterMainActivity ( var viewActivity:ViewActivity ): Presenter {


    override fun onCreate() {
    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onDestroy() {

    }

    override fun sendUserText() {

        var interactor = Interactor(FlickrRepository())
        var userText = viewActivity.getEditText()

        if(userText !=null) {
            //EditTextObservable
            RxTextView.textChangeEvents(userText)
                    .skip(1)
                    .debounce(500, TimeUnit.MILLISECONDS)
                    .filter(Predicate { search -> !search.text().isEmpty()})
                    .flatMap { search->  interactor.call.getDataFlickrRepository(search.text().toString()) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread() )
                    .unsubscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer{ f ->  viewActivity.showPicturesInList(f.items) },
                            Consumer { e -> viewActivity.showError("Error: " + e.message )  })
        }
    }

}