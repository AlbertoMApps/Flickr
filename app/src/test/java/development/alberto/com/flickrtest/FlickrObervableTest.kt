package development.alberto.com.flickrtest

import development.alberto.com.flickrtest.data.api.FlickrApi
import development.alberto.com.flickrtest.data.constant.Constant
import development.alberto.com.flickrtest.data.model.Flickr
import development.alberto.com.flickrtest.data.service.RetrofitService
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.observers.TestObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by alber on 13/09/2017.
 */

@RunWith(MockitoJUnitRunner::class)
class FlickrObervableTest(){

    @Mock
    lateinit var restApiFlickr:FlickrApi
    var retrofitService:RetrofitService = RetrofitService()
    val flickrObserver: TestObserver<List<Flickr>> = TestObserver()

    @Before
    fun setup(){
        retrofitService.restApiServiceFlickr(Constant.FLICKR_BASE_URL)
        restApiFlickr = retrofitService.createRestFlikrApi()!!
    }

    @Test
    fun performFlickrRestServiceTest(){
        var flickrObservable: Observable<List<Flickr>> = restApiFlickr.getFLickrListObservableTest("test")

        flickrObservable.subscribeWith(flickrObserver)
        flickrObservable.subscribe(Consumer { data -> Assert.assertNotNull(data) })
        flickrObservable.subscribe(Consumer {data -> Assert.assertTrue(data.size > 0) })
        flickrObserver.assertNoErrors()
        Assert.assertNotNull( flickrObserver.values() )
        flickrObserver.assertNoTimeout()
    }

}