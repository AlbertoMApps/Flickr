package development.alberto.com.flickrtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by alber on 11/09/2017.
 */


class Media {
    @SerializedName("m")
    @Expose
    var m: String? = null

}