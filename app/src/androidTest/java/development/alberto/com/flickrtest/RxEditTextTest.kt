package development.alberto.com.flickrtest

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import development.alberto.com.flickrtest.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.ViewMatchers.withId


/**
 * Created by alber on 12/09/2017.
 */

@RunWith(AndroidJUnit4::class)
class RxEditTextTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun rxEditTextSearchTest() {
        onView(withId(R.id.etSearch)).perform(typeText("Spain"));
    }
    fun showImagesPath(){

    }
}