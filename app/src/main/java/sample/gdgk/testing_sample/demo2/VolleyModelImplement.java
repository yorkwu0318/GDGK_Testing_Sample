package sample.gdgk.testing_sample.demo2;

import com.android.volley.Response;

import sample.gdgk.testing_sample.demo1.GsonRequest;
import sample.gdgk.testing_sample.demo1.MyVolley;
import sample.gdgk.testing_sample.model.LoginResponse;

public class VolleyModelImplement implements VolleyModel {
    @Override
    public void login(String email,
                      String password,
                      Response.Listener<LoginResponse> listener,
                      Response.ErrorListener errorListener) {

        GsonRequest<LoginResponse> request = new GsonRequest<>(
                "http://api.raguhn.tw/login-test.php?account="+email+"&password="+password,
                LoginResponse.class,
                null,
                listener,
                errorListener);

        MyVolley.getInstance(null).addToRequestQueue(request);

    }
}
