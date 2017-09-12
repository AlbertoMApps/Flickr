package development.alberto.com.flickrtest.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import development.alberto.com.flickrtest.R
import development.alberto.com.flickrtest.business.interactor.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Predicate
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var interactor:Interactor = Interactor()

        if(etSearch.text.toString()!=null) {
            //EditTextObservable
            RxTextView.textChangeEvents(etSearch)
                    .skip(1)
                    .filter(Predicate { t -> t.toString().length > 1 })
                    .flatMap { search->  interactor.call.getDataFlickrRepository(search.text().toString()) }
                    .subscribeOn(Schedulers.io())
                    .observeOn( Schedulers.from(Executors.newCachedThreadPool()))
                    .unsubscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(Consumer{ t ->  println( t.items!!.size) },
                            Consumer { e -> println("Error: " + e.printStackTrace() )  })
        }
    }
}
