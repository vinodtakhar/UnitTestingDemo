package com.gaadi.dagger.junit.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gaadi.dagger.junit.R;

/**
 * Created by vinodtakhar on 21/12/15.
 */
public class HelloActivity extends AppCompatActivity {

    Button btnLoad;
    TextView tvLoaded;

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.hello_activity);

        btnLoad = (Button)findViewById(R.id.load);
        tvLoaded = (TextView)findViewById(R.id.done);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvLoaded.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tvLoaded.setVisibility(View.VISIBLE);
                    }
                },1000*30);
            }
        });
    }
}
