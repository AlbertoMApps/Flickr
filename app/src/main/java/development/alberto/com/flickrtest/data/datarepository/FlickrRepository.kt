package development.alberto.com.flickrtest.data.datarepository

import development.alberto.com.flickrtest.business.flickrrepository.CallFlickrRepository
import development.alberto.com.flickrtest.data.api.FlickrApi
import development.alberto.com.flickrtest.data.constant.Constant
import development.alberto.com.flickrtest.data.model.Flickr
import development.alberto.com.flickrtest.data.service.RetrofitService
import io.reactivex.Observable

/**
 * Created by alber on 11/09/2017.
 */

class FlickrRepository: CallFlickrRepository {

    var retrofitService: RetrofitService = RetrofitService()
    lateinit var apiServiceFlickr: FlickrApi

    override fun getDataFlickrRepository(tag:String): Observable<Flickr> {
        retrofitService.restApiServiceFlickr(Constant.FLICKR_BASE_URL)
        apiServiceFlickr = retrofitService.createRestFlikrApi()!!
         return apiServiceFlickr.getFLickrObservable(tag)
    }

}