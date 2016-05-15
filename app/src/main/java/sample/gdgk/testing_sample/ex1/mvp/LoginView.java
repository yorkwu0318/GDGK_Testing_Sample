package sample.gdgk.testing_sample.ex1.mvp;

public interface LoginView {
    void showLoginError(String message);
    void showLoginSuccess();
    void showLoginFailed();
}
