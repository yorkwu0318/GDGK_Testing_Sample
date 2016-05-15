package sample.gdgk.testing_sample.ex2.mvp;

public interface LoginView {
    void showEmailError();
    void showPasswordError();
    void clearErrorMessage();

    void showLoginError(String message);
    void showLoginSuccess();
    void showLoginFailed();
}
