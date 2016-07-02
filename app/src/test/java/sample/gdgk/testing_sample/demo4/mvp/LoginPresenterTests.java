package sample.gdgk.testing_sample.demo4.mvp;

import com.android.volley.VolleyError;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import sample.gdgk.testing_sample.demo2.VolleyModel;
import sample.gdgk.testing_sample.inject.FakeVolleyModel;
import sample.gdgk.testing_sample.model.LoginResponse;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTests {

    @Mock
    public LoginView view;

    @Before
    public void setup() {

    }

    @Test
    public void testLoginSuccess() {
        VolleyModel model = new FakeVolleyModel();
        LoginPresenter presenter = new LoginPresenter(view, model);
        presenter.login("test@abc.com", "123456");

        verify(view).showLoginSuccess();
    }

    @Test
    public void testLoginFailed() {
        VolleyModel model = (email, password, listener, errorListener) -> listener.onResponse(new LoginResponse(0));

        LoginPresenter presenter = new LoginPresenter(view, model);
        presenter.login("test@abc.com", "123456");

        verify(view).showLoginFailed();
    }

    @Test
    public void testLoginError() {
        VolleyModel model = (email, password, listener, errorListener) -> errorListener.onErrorResponse(new VolleyError());

        LoginPresenter presenter = new LoginPresenter(view, model);
        presenter.login("test@abc.com", "123456");

        verify(view).showLoginError();
    }
}
