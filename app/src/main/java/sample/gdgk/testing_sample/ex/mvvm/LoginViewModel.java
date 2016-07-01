package sample.gdgk.testing_sample.ex.mvvm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import rx.Subscriber;
import sample.gdgk.testing_sample.inject.Injection;
import sample.gdgk.testing_sample.model.LoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;

public class LoginViewModel {
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");

    public ObservableBoolean emailError = new ObservableBoolean();
    public ObservableBoolean passwordError = new ObservableBoolean();

    private RetrofitModel model;
    private LoginView view;

    public void setDependency(LoginView view, RetrofitModel model) {
        this.view = view;
        this.model = model;
    }

    public void onLoginButtonClicked() {
        if (!checkValid()) {
            return;
        }
        requestLogin();
    }

    private boolean checkValid() {
        emailError.set("".equals(email.get()));
        passwordError.set("".equals(password.get()));
        return !(emailError.get() || passwordError.get());
    }

    private void requestLogin() {
        model.login(email.get(), password.get())
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
                view.showLoginErrorMessage();
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
