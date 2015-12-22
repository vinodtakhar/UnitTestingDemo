package com.gaadi.dagger.junit.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gaadi.dagger.junit.R;

public class LoginResultActivity extends AppCompatActivity {

    private TextView tvResult,tvUsername,tvPassword;
    private Button btnFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_login_result);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        btnFinish = (Button)findViewById(R.id.btnFinish);

        tvUsername = (TextView)findViewById(R.id.tvUsername);
        tvPassword = (TextView)findViewById(R.id.tvPassword);

        tvResult = (TextView)findViewById(R.id.tvResult);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listIntent = new Intent(LoginResultActivity.this,RecyclerActivity.class);
                startActivity(listIntent);
            }
        });

    }

    @Override
    public void onResume(){
        super.onResume();

        Bundle bundle=getIntent().getExtras();

        String username=bundle.getString("username");
        String password=bundle.getString("password");

        if(username.equals("vinod") && password.equals("vinod")){
            tvResult.setText("Login Success!");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

            tvUsername.setText(username);
            tvPassword.setText(password);

            setControlVisibility(View.VISIBLE);
        }
        else{
            tvResult.setText("Incorrect username or password");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));

            setControlVisibility(View.GONE);
        }
    }

    private void setControlVisibility(int visible) {
        tvPassword.setVisibility(visible);
        tvUsername.setVisibility(visible);
    }

    @Override
    public void onPause(){
        super.onPause();
    }


}
