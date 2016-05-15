package sample.gdgk.testing_sample.ex2.mvvm;

import rx.Subscriber;
import sample.gdgk.testing_sample.inject.Injection;
import sample.gdgk.testing_sample.model.RetrofitModel;
import sample.gdgk.testing_sample.model.LoginResponse;

public class LoginPresenter {
    private LoginView view;
    private LoginViewModel viewModel;
    private RetrofitModel model;

    public LoginPresenter(LoginView view, LoginViewModel viewModel, RetrofitModel model) {
        this.view = view;
        this.viewModel = viewModel;
        this.model = model;
    }

    public void onLoginButtonClicked() {
        if (!checkValid()) {
            return;
        }
        requestLogin();
    }

    private boolean checkValid() {
        viewModel.emailError.set("".equals(viewModel.email.get()));
        viewModel.passwordError.set("".equals(viewModel.password.get()));
        return !(viewModel.emailError.get() || viewModel.passwordError.get());
    }

    private void requestLogin() {
        model.login(viewModel.email.get(), viewModel.password.get())
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
                view.showLoginErrorMessage(e.getMessage());
            }

            @Override
            public void onNext(LoginResponse loginResponse) {
                if (loginResponse.status == 1) {
                    view.showLoginSuccessMessage();
                } else {
                    view.showLoginFailedMessage();
                }
            }
        };
    }
}
