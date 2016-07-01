package sample.gdgk.testing_sample.inject;

import com.android.volley.Response;

import sample.gdgk.testing_sample.demo2.VolleyModel;
import sample.gdgk.testing_sample.model.LoginResponse;

public class FakeVolleyModel implements VolleyModel {
    @Override
    public void login(String email,
                      String password,
                      Response.Listener<LoginResponse> listener,
                      Response.ErrorListener errorListener) {
        LoginResponse response = new LoginResponse();
        response.status = 1;

        listener.onResponse(response);
    }
}
