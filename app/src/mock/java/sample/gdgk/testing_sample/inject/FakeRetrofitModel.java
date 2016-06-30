package sample.gdgk.testing_sample.inject;

import rx.Observable;
import sample.gdgk.testing_sample.mock.FakeLoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;
import sample.gdgk.testing_sample.model.LoginResponse;

public class FakeRetrofitModel implements RetrofitModel {
    @Override
    public Observable<LoginResponse> login(String email, String password) {
        if ("123".equals(email) && "456".equals(password)) {
            return Observable.just(FakeLoginResponse.mockSuccessResponse());
        } else if ("123".equals(email)) {
            return Observable.just(FakeLoginResponse.mockFailedResponse());
        } else {
            return Observable.error(new Throwable("error"));
        }
    }
}
