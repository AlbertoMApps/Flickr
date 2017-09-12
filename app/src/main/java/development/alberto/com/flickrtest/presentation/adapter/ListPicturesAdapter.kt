package development.alberto.com.flickrtest.presentation.adapter

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import development.alberto.com.flickrtest.data.model.Item
import development.alberto.com.flickrtest.presentation.view.initialpictures.MainActivity
import kotlinx.android.synthetic.main.flickr_pics_row.view.*

/**
 * Created by alber on 12/09/2017.
 */

class ListPicturesAdapter(var context: MainActivity, var mLayout: Int) : RecyclerView.Adapter<ListPicturesAdapter.ViewHolder>() {

    var listPictures:List<Item> = ArrayList<Item>() as List<Item>

//    fun updateListImages(lPictures:List<Item>){
//        listPictures = lPictures
//    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bindItems( this.listPictures.get(position) )
//        holder.itemView.setOnClickListener(View.OnClickListener {
//            val anim = ViewAnimationUtils.createCircularReveal(holder.itemView.ivPictures, 100, 100, 1000f, 0f)
//            anim.start()
//        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(mLayout, parent, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount(): Int {
        return this::listPictures.get().size
    }


    class ViewHolder(itemView: View?, var context: MainActivity) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(picture: Item) {
            Picasso.with(context)
                    .load(picture.media!!.m!!.toString())
                    .resize(250, 250)
                    .into(itemView.ivPictures)
        }
    }


}