package sample.gdgk.testing_sample.inject;

import com.android.volley.Response.*;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import sample.gdgk.testing_sample.ex1.mvc.volley.GsonRequest;
import sample.gdgk.testing_sample.ex1.mvc.volley.LoginModel;
import sample.gdgk.testing_sample.model.LoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;

public class Injection {
    public static Scheduler ObserveScheduler() {
        return AndroidSchedulers.mainThread();
    }

    public static Scheduler SubscribeScheduler() {
        return Schedulers.newThread();
    }

    public static RetrofitModel provideRetrofitModel() {
        return ApiGenerator.createApi(RetrofitModel.class);
    }

    public static LoginModel provideLoginModel() {
        return new LoginModel() {
            @Override
            public GsonRequest<LoginResponse> login(String email, String password,
                                                    Listener listener, ErrorListener errorListener) {
                return new GsonRequest<>("http://api.raguhn.tw/login-test.php?account="+email+"&password="+password
                        , LoginResponse.class,
                        null, listener, errorListener);
            }
        };
    }
}
