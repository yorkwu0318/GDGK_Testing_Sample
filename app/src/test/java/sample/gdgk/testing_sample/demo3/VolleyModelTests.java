package sample.gdgk.testing_sample.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import sample.gdgk.testing_sample.demo2.VolleyModel;
import sample.gdgk.testing_sample.inject.Injection;

@RunWith(MockitoJUnitRunner.class)
public class VolleyModelTests {

    @Test
    public void testLoginModel() {
        VolleyModel model = Injection.provideVolleyModel();

//        when(model.login(anyString(), anyString(), ))

//        model.login("123", "456", getListener, getListener);
//        verify(Snackbar).show();
    }
}
