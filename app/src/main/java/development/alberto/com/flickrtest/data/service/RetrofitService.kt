package development.alberto.com.flickrtest.data.service

import development.alberto.com.flickrtest.data.api.FlickrApi
import development.alberto.com.flickrtest.data.constant.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by alber on 11/09/2017.
 */

class RetrofitService {

    fun restApiServiceFlickr(): FlickrApi {
        var retrofit: Retrofit? = Retrofit.Builder()
                .baseUrl(Constant.FLICKR_BASE_URL)
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit!!.create(FlickrApi::class.java)
    }

}