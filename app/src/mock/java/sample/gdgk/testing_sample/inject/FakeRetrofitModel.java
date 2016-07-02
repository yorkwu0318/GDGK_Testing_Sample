package sample.gdgk.testing_sample.inject;

import rx.Observable;
import sample.gdgk.testing_sample.model.RetrofitModel;
import sample.gdgk.testing_sample.model.LoginResponse;

public class FakeRetrofitModel implements RetrofitModel {
    @Override
    public Observable<LoginResponse> login(
            String email,
            String password) {
        return Observable.just(new LoginResponse(1));
    }
}
