package sample.gdgk.testing_sample.demo3;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import sample.gdgk.testing_sample.R;
import sample.gdgk.testing_sample.demo2.VolleyModel;
import sample.gdgk.testing_sample.inject.Injection;
import sample.gdgk.testing_sample.model.LoginResponse;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private VolleyModel model = Injection.provideVolleyModel();
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
            model.login(emailEdit.getText().toString(),
                    passwordEdit.getText().toString(),
                    new Response.Listener<LoginResponse>() {
                        @Override
                        public void onResponse(LoginResponse response) {
                            if (response.status == 1) {
                                Snackbar.make(root, R.string.login_success, Snackbar.LENGTH_LONG).show();
                            } else {
                                Snackbar.make(root, R.string.login_failed, Snackbar.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });


        }
    }

}
