package sample.gdgk.testing_sample.inject;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
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
}
