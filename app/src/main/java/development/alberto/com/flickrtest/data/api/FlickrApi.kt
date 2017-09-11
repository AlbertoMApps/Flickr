package development.alberto.com.flickrtest.data.api

import development.alberto.com.flickrtest.data.constant.Constant
import development.alberto.com.flickrtest.data.model.Flickr
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by alber on 11/09/2017.
 */
interface FlickrApi {
    @GET(Constant.FLICKER_SEARCH_BY_TAG)
    fun getFLickrObservable(@Query("tag") tag: String): Observable<Flickr>
}