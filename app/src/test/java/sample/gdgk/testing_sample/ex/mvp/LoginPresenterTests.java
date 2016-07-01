package sample.gdgk.testing_sample.ex.mvp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import rx.Observable;
import sample.gdgk.testing_sample.mock.FakeLoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTests {

    @Mock
    private LoginView view;

    private LoginPresenter presenter;

    @Mock
    private RetrofitModel model;


    @Before
    public void setup() {
        presenter = new LoginPresenter(view, model);
    }

    @Test
    public void testLoginSuccess() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.just(FakeLoginResponse.mockSuccessResponse()));

        presenter.checkValidAndLogin("test@abc.com", "123456");
        verify(model).login("test@abc.com", "123456");
        verify(view).showLoginSuccess();
    }

    @Test
    public void testLoginFailed() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.just(FakeLoginResponse.mockFailedResponse()));
        presenter.checkValidAndLogin("test@abc.com", "123456");
        verify(view).showLoginFailed();
    }

    @Test
    public void testLoginError() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.error(new Throwable()));
        presenter.checkValidAndLogin("test@abc.com", "123456");
        verify(view).showLoginError();
    }

    @Test
    public void testValidWithEmptyEmail() {
        presenter.checkValidAndLogin("", "123456");
        verify(view).showEmailError();
    }

    @Test
    public void testValidWithEmptyPassword() {
        presenter.checkValidAndLogin("test@abc.com", "");
        verify(view).showPasswordError();
    }
}
