package sample.gdgk.testing_sample.ex.mvvm;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

public class LoginViewModel {
    public ObservableField<String> email = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");

    public ObservableBoolean emailError = new ObservableBoolean();
    public ObservableBoolean passwordError = new ObservableBoolean();

}
