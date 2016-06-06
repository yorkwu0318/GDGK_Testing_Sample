package sample.gdgk.testing_sample.ex1.mvpvm;

import android.databinding.ObservableField;

public class LoginViewModel {
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");
}
