package sample.gdgk.testing_sample.demo4.mvvm;

import android.databinding.ObservableField;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import sample.gdgk.testing_sample.demo2.VolleyModel;
import sample.gdgk.testing_sample.model.LoginResponse;

public class LoginViewModel {
    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();

    private LoginView view;
    private VolleyModel model;

    public void setDependency(LoginView view, VolleyModel model) {
        this.view = view;
        this.model = model;
    }

    public void login() {
        model.login(email.get(),
                password.get(),
                new Response.Listener<LoginResponse>() {
                    @Override
                    public void onResponse(LoginResponse response) {
                        if (response.status == 1) {
                            view.showLoginSuccess();
                        } else {
                            view.showLoginFailed();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        view.showLoginError();
                    }
                });
    }
}
