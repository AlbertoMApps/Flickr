package development.alberto.com.flickrtest.presentation.view

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import development.alberto.com.flickrtest.R
import development.alberto.com.flickrtest.presentation.view.initialpictures.MainActivity

/**
 * Created by alber on 12/09/2017.
 */

class SplashImage : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            // Set portrait orientation
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            // Hide title bar
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            //set content layout
            setContentView(R.layout.activity_splash)

            val background = object : Thread() {
                override fun run() {
                    try {
                        // Thread will sleep for 5 seconds
                        Thread.sleep((5 * 1000).toLong())
                        // After 5 seconds redirect to another intent
                        val i = Intent(this@SplashImage, MainActivity::class.java)
                        startActivity(i)
                        //Remove activity
                        finish()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                }
            }
            // start thread
            background.start()
        }
}