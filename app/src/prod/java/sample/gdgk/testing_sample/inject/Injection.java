package sample.gdgk.testing_sample.inject;

import rx.Scheduler;
import rx.schedulers.Schedulers;
import sample.gdgk.testing_sample.model.CommonModel;

public class Injection {
    public static Scheduler ObserveScheduler() {
        return Schedulers.immediate();
    }

    public static Scheduler SubscribeScheduler() {
        return Schedulers.immediate();
    }

    public static CommonModel provideCommonModel() {
        return ApiGenerator.createApi(CommonModel.class);
    }
}
