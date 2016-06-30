package sample.gdgk.testing_sample.demo2;

import com.android.volley.Response;

import sample.gdgk.testing_sample.model.LoginResponse;

public interface VolleyModel {
    void login(String email,
               String password,
               Response.Listener<LoginResponse> listener,
               Response.ErrorListener errorListener);
}
