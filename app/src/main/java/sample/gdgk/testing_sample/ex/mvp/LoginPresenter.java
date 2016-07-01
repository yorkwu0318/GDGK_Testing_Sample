package sample.gdgk.testing_sample.ex.mvp;

import rx.Subscriber;
import sample.gdgk.testing_sample.inject.Injection;
import sample.gdgk.testing_sample.model.LoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;

public class LoginPresenter {
    private LoginView view;
    private RetrofitModel model;

    public LoginPresenter(LoginView view, RetrofitModel model) {
        this.view = view;
        this.model = model;
    }

    public void checkValidAndLogin(String email, String password) {

        boolean isPassed = true;

        view.clearErrorMessage();

        if ("".equals(email)) {
            view.showEmailError();
            isPassed = false;
        }

        if ("".equals(password)) {
            view.showPasswordError();
            isPassed = false;
        }

        if (!isPassed) {
            return;
        }

        login(email, password);
    }

    private void login(String email, String password) {
        model.login(email, password)
                .observeOn(Injection.ObserveScheduler())
                .subscribeOn(Injection.SubscribeScheduler())
                .subscribe(getSubscriber());
    }

    public Subscriber<LoginResponse> getSubscriber() {
        return new Subscriber<LoginResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showLoginError(e.getMessage());
            }

            @Override
            public void onNext(LoginResponse loginResponse) {
                if (loginResponse.status == 1) {
                    view.showLoginSuccess();
                } else {
                    view.showLoginFailed();
                }
            }
        };
    }
}
