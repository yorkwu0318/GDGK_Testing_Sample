package sample.gdgk.testing_sample.demo4.mvp;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import sample.gdgk.testing_sample.demo2.VolleyModel;
import sample.gdgk.testing_sample.model.LoginResponse;

public class LoginPresenter {
    private LoginView view;
    private VolleyModel model;

    public LoginPresenter(LoginView view, VolleyModel model) {
        this.view = view;
        this.model = model;
    }

    public void checkValidAndLogin(String email, String password) {

        login(email, password);
    }

    private void login(String email, String password) {
        model.login(email,
                password,
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
