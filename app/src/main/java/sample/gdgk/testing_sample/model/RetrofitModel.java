package sample.gdgk.testing_sample.model;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitModel {

    @GET("/login-test.php")
    Observable<LoginResponse> login(@Query("account") String email, @Query("password") String password);
}
