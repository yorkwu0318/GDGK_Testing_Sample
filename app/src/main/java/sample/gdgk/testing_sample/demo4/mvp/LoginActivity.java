package sample.gdgk.testing_sample.demo4.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.inject.Injection;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter presenter = new LoginPresenter(this, Injection.provideVolleyModel());

    private View root;

    @SuppressWarnings("all")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo4);

        root = findViewById(R.id.root);

        EditText emailEdit = (EditText) findViewById(R.id.emailEdit);
        EditText passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        View loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> presenter.checkValidAndLogin(emailEdit.getText().toString(),
                passwordEdit.getText().toString()));


    }

    @Override
    public void showLoginError() {
        Snackbar.make(root, R.string.login_error, Snackbar.LENGTH_LONG).show();
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
