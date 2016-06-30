package sample.gdgk.testing_sample;

import android.app.Application;

import sample.gdgk.testing_sample.demo1.MyVolley;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MyVolley.getInstance(this);
    }
}
