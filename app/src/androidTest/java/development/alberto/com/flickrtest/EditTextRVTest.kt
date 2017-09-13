package development.alberto.com.flickrtest

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import development.alberto.com.flickrtest.presentation.view.initialpictures.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.v7.widget.RecyclerView


/**
 * Created by alber on 12/09/2017.
 */

@RunWith(AndroidJUnit4::class)
class EditTextRVTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun rxEditTextSearchTest() {
        onView(withId(R.id.etSearch)).perform(typeText("image"));
    }
    @Test
    @Throws(Exception::class)
    fun showImagesPathTest(){
        onView(withId(R.id.etSearch)).perform(typeText("image"));
        onView(ViewMatchers.withText("item")).check(ViewAssertions.doesNotExist())
        //we will wait till the recycler view is loaded...
        Thread.sleep(5000)
        //the, we will actually make a path
        onView(withId(R.id.picturesListView))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(4))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(6, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(7, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(8, ViewActions.click()))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(9, ViewActions.click()))
    }
}