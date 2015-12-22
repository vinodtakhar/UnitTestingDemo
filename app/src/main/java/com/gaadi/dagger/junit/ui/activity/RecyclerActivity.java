package com.gaadi.dagger.junit.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gaadi.dagger.junit.R;
import com.gaadi.dagger.junit.ui.fragments.RecyclerViewFragment;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

//        ((MyApplication)getApplication()).component().inject(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, new RecyclerViewFragment());
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

}
