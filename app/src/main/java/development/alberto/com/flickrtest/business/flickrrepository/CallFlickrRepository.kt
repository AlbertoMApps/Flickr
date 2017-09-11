package development.alberto.com.flickrtest.business.flickrrepository

import development.alberto.com.flickrtest.data.model.Flickr
import io.reactivex.Observable

/**
 * Created by alber on 11/09/2017.
 */

interface CallFlickrRepository {
    fun getDataFlickrRepository(tag:String): Observable<Flickr>
}