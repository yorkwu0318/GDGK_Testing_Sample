package sample.gdgk.testing_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import sample.gdgk.testing_sample.ex1.mvc.LoginActivity;

public class ListActivity extends NavigationUpActivity {
    public static final String INTENT_TYPE = "intent_type";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        int type = getIntent().getIntExtra(INTENT_TYPE, 0);

        List<ListItem> list;
        if (type == 0) {
            toolbar.setTitle("MVC");
            list = getMVCList();
        } else if (type == 1) {
            toolbar.setTitle("MVP");
            list = getMVPList();
        } else {
            toolbar.setTitle("MVVM");
            list = getMVVMList();
        }

        recyclerView.setAdapter(new ListAdapter(list));

        setSupportActionBar(toolbar);
    }

    private List<ListItem> getMVCList() {
        List<ListItem> list = new ArrayList<>();
        list.add(new ListItem("ex1", LoginActivity.class));
        list.add(new ListItem("ex2", sample.gdgk.testing_sample.ex2.mvc.LoginActivity.class));

        return list;
    }

    private List<ListItem> getMVPList() {
        List<ListItem> list = new ArrayList<>();
        list.add(new ListItem("ex1", sample.gdgk.testing_sample.ex1.mvp.LoginActivity.class));
        list.add(new ListItem("ex2", sample.gdgk.testing_sample.ex2.mvp.LoginActivity.class));

        return list;
    }

    private List<ListItem> getMVVMList() {
        List<ListItem> list = new ArrayList<>();
        list.add(new ListItem("ex1", sample.gdgk.testing_sample.ex1.mvvm.LoginActivity.class));
        list.add(new ListItem("ex2", sample.gdgk.testing_sample.ex2.mvvm.LoginActivity.class));

        return list;
    }
}
