package sample.gdgk.testing_sample.ex2.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.inject.Injection;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter presenter = new LoginPresenter(this, Injection.provideRetrofitModel());
    private TextInputLayout emailTextInputLayout;
    private TextInputLayout passwordTextInputLayout;

    private View root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ex2);

        root = findViewById(R.id.root);

        emailTextInputLayout = (TextInputLayout) findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordTextInputLayout);

        EditText emailEdit = (EditText) findViewById(R.id.emailEdit);
        EditText passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        View loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> presenter.checkValidAndLogin(emailEdit.getText().toString(),
                passwordEdit.getText().toString()));


    }

    @Override
    public void showEmailError() {
        emailTextInputLayout.setError(getString(R.string.email_error));
    }

    @Override
    public void showPasswordError() {
        passwordTextInputLayout.setError(getString(R.string.password_error));
    }

    @Override
    public void clearErrorMessage() {
        emailTextInputLayout.setError("");
        passwordTextInputLayout.setError("");
    }

    @Override
    public void showLoginError(String message) {
        Snackbar.make(root, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccess() {
        Snackbar.make(root, R.string.login_success, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFailed() {
        Snackbar.make(root, R.string.login_failed, Snackbar.LENGTH_LONG).show();
    }
}
