package com.gaadi.dagger.junit.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gaadi.dagger.junit.R;

public class SquareCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_calculator);

        calculateAndRespond();
    }

    private void calculateAndRespond() {
        int number = getIntent().getIntExtra("number",1);

        final int result = number*number;

        findViewById(R.id.progressBar).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent data = new Intent();
                data.putExtra("result", result);
                setResult(Activity.RESULT_OK, data);

                SquareCalculator.this.finish();
            }
        }, 10 * 1000);

    }

}
