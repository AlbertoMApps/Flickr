package development.alberto.com.flickrtest.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by alber on 11/09/2017.
 */

class Flickr {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("link")
    @Expose
    var link: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("generator")
    @Expose
    var generator: String? = null
    @SerializedName("items")
    @Expose
    var items: List<Item>? = null

}
