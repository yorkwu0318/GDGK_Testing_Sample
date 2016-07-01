package sample.gdgk.testing_sample.demo4.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.databinding.ActivityDemo4MvvmBinding;
import sample.gdgk.testing_sample.inject.Injection;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private ActivityDemo4MvvmBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginViewModel viewModel = new LoginViewModel();
        viewModel.setDependency(this, Injection.provideVolleyModel());

        binding = DataBindingUtil.setContentView(this, R.layout.activity_demo4_mvvm);
        binding.setViewModel(viewModel);
    }

    @Override
    public void showLoginError() {
        Snackbar.make(binding.getRoot(), R.string.login_error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccess() {
        Snackbar.make(binding.getRoot(), R.string.login_success, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFailed() {
        Snackbar.make(binding.getRoot(), R.string.login_failed, Snackbar.LENGTH_LONG).show();
    }
}
