package sample.gdgk.testing_sample.ex.mvvm;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import rx.Observable;
import sample.gdgk.testing_sample.model.LoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTests {

    @Mock
    private LoginView view;

    private LoginViewModel viewModel;

    @Mock
    private RetrofitModel model;


    @Before
    public void setup() {
        viewModel = new LoginViewModel();
        viewModel.setDependency(view, model);
    }

    @Test
    public void testLoginSuccess() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.just(new LoginResponse(1)));
        viewModel.email.set("test@abc.com");
        viewModel.password.set("123456");

        viewModel.onLoginButtonClicked();
        verify(model).login("test@abc.com", "123456");
        verify(view).showLoginSuccessMessage();
    }

    @Test
    public void testLoginFailed() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.just(new LoginResponse(0)));
        viewModel.email.set("test@abc.com");
        viewModel.password.set("123456");

        viewModel.onLoginButtonClicked();
        verify(view).showLoginFailedMessage();
    }

    @Test
    public void testLoginError() {
        when(model.login(anyString(), anyString())).thenReturn(Observable.error(new Throwable()));
        viewModel.email.set("test@abc.com");
        viewModel.password.set("123456");

        viewModel.onLoginButtonClicked();
        verify(view).showLoginErrorMessage();
    }

    @Test
    public void testValidWithEmptyEmail() {
        viewModel.password.set("123456");
        viewModel.onLoginButtonClicked();

        Assert.assertEquals(true, viewModel.emailError.get());
    }

    @Test
    public void testValidWithEmptyPassword() {
        viewModel.email.set("123456");
        viewModel.onLoginButtonClicked();

        Assert.assertEquals(true, viewModel.passwordError.get());
    }
}
