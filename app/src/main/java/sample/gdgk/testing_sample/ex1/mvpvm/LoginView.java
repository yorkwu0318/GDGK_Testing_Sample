package sample.gdgk.testing_sample.ex1.mvpvm;

public interface LoginView {
    void showLoginSuccessMessage();

    void showLoginFailedMessage();

    void showLoginErrorMessage(String message);
}
