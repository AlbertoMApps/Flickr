package development.alberto.com.flickrtest.data.service

import development.alberto.com.flickrtest.data.api.FlickrApi
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

/**
 * Created by alber on 11/09/2017.
 */

class RetrofitService {

    var retrofit: Retrofit? = null

    fun restApiServiceFlickr(urlBase:String) {
        retrofit = Retrofit.Builder()
                .baseUrl(urlBase)
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.from(Executors.newCachedThreadPool())))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun createRestFlikrApi(): FlickrApi? {
        return retrofit!!.create(FlickrApi::class.java)
    }

}