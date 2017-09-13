package development.alberto.com.flickrtest

import android.widget.EditText
import com.jakewharton.rxbinding2.widget.RxTextView
import development.alberto.com.flickrtest.business.interactor.Interactor
import development.alberto.com.flickrtest.presentation.presenter.initialpictures.PresenterMainActivity
import development.alberto.com.flickrtest.presentation.view.initialpictures.ViewActivity
import io.reactivex.functions.Predicate
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner
import java.util.concurrent.TimeUnit


/**
 * Created by alber on 13/09/2017.
 */

@RunWith(MockitoJUnitRunner::class)
class RxEditTextPresenterTest {

    @Mock
    lateinit var view: ViewActivity
    @Mock
    lateinit var et:EditText
    lateinit var presenter:PresenterMainActivity
    lateinit var interactor: Interactor


    @Before
    fun setup(){
        presenter = PresenterMainActivity(view)
        interactor = Interactor()
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun checkViewAndRxCallTest() {
        Assert.assertNotNull(view)
        Assert.assertNotNull(et)
        Assert.assertNotNull(presenter)
        Assert.assertNotNull(interactor)
        presenter.sendUserText()
    }

    @Test
    fun pathRxCallTest() {
        val value = "text"
        //Test editText when we set a value
        Mockito.doCallRealMethod().`when`(et).setText(value)
        Mockito.doCallRealMethod().`when`(et).getText()
        //then test RX view call binding and checking that it is emitting and not null
        RxTextView.textChangeEvents(et)
                .skip(1)
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter(Predicate { search -> !search.text().isEmpty() })
                .flatMap { search->  interactor.call.getDataFlickrRepository(search.text().toString()) }
                .map { t ->Assert.assertNotNull(t)  }
    }
}
