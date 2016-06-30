package sample.gdgk.testing_sample.ex1;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import rx.Subscriber;
import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.inject.Injection;
import sample.gdgk.testing_sample.model.LoginResponse;
import sample.gdgk.testing_sample.model.RetrofitModel;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private RetrofitModel model = Injection.provideRetrofitModel();
    private EditText emailEdit;
    private EditText passwordEdit;
    private View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        root = findViewById(R.id.root);

        emailEdit = (EditText) findViewById(R.id.emailEdit);
        passwordEdit = (EditText) findViewById(R.id.passwordEdit);

        View loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.loginButton) {
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

}
