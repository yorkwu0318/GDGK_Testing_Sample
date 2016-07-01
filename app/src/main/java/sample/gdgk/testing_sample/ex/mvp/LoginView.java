package sample.gdgk.testing_sample.ex.mvp;

public interface LoginView {
    void showEmailError();
    void showPasswordError();
    void clearErrorMessage();

    void showLoginError();
    void showLoginSuccess();
    void showLoginFailed();
}
