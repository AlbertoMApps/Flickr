package development.alberto.com.flickrtest.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import development.alberto.com.flickrtest.R
import development.alberto.com.flickrtest.business.interactor.Interactor
import development.alberto.com.flickrtest.data.model.Flickr
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doFlickr = object : DisposableObserver<Flickr>() {
            override fun onComplete() {
                println("finished y ole!")
            }

            override fun onNext(flickr: Flickr) {
                println(flickr.items!!.get(0).media!!.m)
            }

            override fun onError(e: Throwable) {
                println(e.message)
            }
        }

        var interactor:Interactor = Interactor()

        interactor.call.getDataFlickrRepository("Spain")
                .subscribeOn(Schedulers.io())
                .observeOn( Schedulers.from(Executors.newCachedThreadPool()))
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(doFlickr)

    }
}
