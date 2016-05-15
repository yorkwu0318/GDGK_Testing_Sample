package sample.gdgk.testing_sample.ex2.mvvm;

public interface LoginView {
    void showLoginSuccessMessage();

    void showLoginFailedMessage();

    void showLoginErrorMessage(String message);
}
