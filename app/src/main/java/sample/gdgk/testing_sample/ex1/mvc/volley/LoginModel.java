package sample.gdgk.testing_sample.ex1.mvc.volley;

import com.android.volley.Response;

import sample.gdgk.testing_sample.model.LoginResponse;

public interface LoginModel {
    GsonRequest<LoginResponse> login(String email, String password,
                                     Response.Listener<LoginResponse> listener, Response.ErrorListener errorListener);
}
