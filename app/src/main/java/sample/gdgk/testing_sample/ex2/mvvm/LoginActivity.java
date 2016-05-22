package sample.gdgk.testing_sample.ex2.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.databinding.ActivityEx2MvvmBinding;
import sample.gdgk.testing_sample.inject.Injection;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;
    private ActivityEx2MvvmBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginViewModel viewModel = new LoginViewModel();
        presenter = new LoginPresenter(this, viewModel, Injection.provideRetrofitModel());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_ex2_mvvm);
        binding.setViewModel(viewModel);
        binding.setPresenter(presenter);
    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(binding.getRoot(), R.string.login_success, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFailedMessage() {
        Snackbar.make(binding.getRoot(), R.string.login_failed, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginErrorMessage(String message) {
        Snackbar.make(binding.getRoot(), R.string.login_error, Snackbar.LENGTH_LONG).show();
    }
}
