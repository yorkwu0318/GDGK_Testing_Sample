package sample.gdgk.testing_sample.ex1.mvvm;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import rx.Observable;
import sample.gdgk.testing_sample.mock.FakeLoginResponse;
import sample.gdgk.testing_sample.model.CommonModel;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTests {

    @Mock
    private LoginView view;

    private LoginPresenter presenter;
    private LoginViewModel viewModel;

    @Mock
    private CommonModel model;


    @Before
    public void setup() {
        viewModel = new LoginViewModel();
        presenter = new LoginPresenter(view, viewModel, model);
    }

    @Test
    public void testLoginSuccess() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.just(FakeLoginResponse.mockSuccessResponse()));
        viewModel.email.set("test@abc.com");
        viewModel.password.set("123456");

        presenter.onLoginButtonClicked();
        verify(model).login("test@abc.com", "123456");
        verify(view).showLoginSuccessMessage();
    }

    @Test
    public void testLoginFailed() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.just(FakeLoginResponse.mockFailedResponse()));
        viewModel.email.set("test@abc.com");
        viewModel.password.set("123456");

        presenter.onLoginButtonClicked();
        verify(view).showLoginFailedMessage();
    }

    @Test
    public void testLoginError() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.error(new Throwable("error message")));
        viewModel.email.set("test@abc.com");
        viewModel.password.set("123456");

        presenter.onLoginButtonClicked();
        verify(view).showLoginErrorMessage("error message");
    }

    @Test
    public void testValidWithEmptyEmail() {
        viewModel.password.set("123456");
        presenter.onLoginButtonClicked();

        Assert.assertEquals(true, viewModel.emailError.get());
    }

    @Test
    public void testValidWithEmptyPassword() {
        viewModel.email.set("123456");
        presenter.onLoginButtonClicked();

        Assert.assertEquals(true, viewModel.passwordError.get());
    }
}
