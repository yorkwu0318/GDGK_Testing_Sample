package sample.gdgk.testing_sample.ex2.mvc;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import rx.Subscriber;
import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.inject.Injection;
import sample.gdgk.testing_sample.model.LoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout emailTextInputLayout;
    private TextInputLayout passwordTextInputLayout;

    private RetrofitModel model = Injection.provideRetrofitModel();
    private EditText emailEdit;
    private EditText passwordEdit;
    private View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        root = findViewById(R.id.root);

        emailTextInputLayout = (TextInputLayout) findViewById(R.id.emailTextInputLayout);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordTextInputLayout);

        emailEdit = (EditText) findViewById(R.id.emailEdit);
        passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        View loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginButton) {
            emailTextInputLayout.setError("");
            passwordTextInputLayout.setError("");

            if (!checkValid()) {
                return;
            }

            model.login(emailEdit.getText().toString(), passwordEdit.getText().toString())
                    .observeOn(Injection.ObserveScheduler())
                    .subscribeOn(Injection.SubscribeScheduler())
                    .subscribe(new Subscriber<LoginResponse>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Snackbar.make(root, e.getMessage(), Snackbar.LENGTH_LONG).show();
                        }

                        @Override
                        public void onNext(LoginResponse loginResponse) {
                            if (loginResponse.status == 1) {
                                Snackbar.make(root, R.string.login_success, Snackbar.LENGTH_LONG).show();
                            } else {
                                Snackbar.make(root, R.string.login_failed, Snackbar.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    private boolean checkValid() {
        String email = emailEdit.getText().toString();
        String password = passwordEdit.getText().toString();

        boolean isPassed = true;

        if ("".equals(email)) {
            emailTextInputLayout.setError(getString(R.string.email_error));
            isPassed = false;
        }

        if ("".equals(password)) {
            passwordTextInputLayout.setError(getString(R.string.password_error));
            isPassed = false;
        }

        return isPassed;
    }
}
