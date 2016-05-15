package sample.gdgk.testing_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.mvcButton).setOnClickListener(v -> onMvcClicked());
        findViewById(R.id.mvpButton).setOnClickListener(v -> onMvpClicked());
        findViewById(R.id.mvvmButton).setOnClickListener(v -> onMvvmClicked());
    }

    private void onMvcClicked() {
        launchListActivity(0);
    }

    private void onMvpClicked() {
        launchListActivity(1);
    }

    private void onMvvmClicked() {
        launchListActivity(2);
    }

    private void launchListActivity(int type) {
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra(ListActivity.INTENT_TYPE, type);
        startActivity(intent);
    }
}
