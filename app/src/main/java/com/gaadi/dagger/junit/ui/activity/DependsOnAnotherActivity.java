package com.gaadi.dagger.junit.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gaadi.dagger.junit.R;

public class DependsOnAnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depends_on_another);



        findViewById(R.id.btnSquare).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText number = (EditText)findViewById(R.id.etNumber);

                int num=0;

                if(number.getText().toString().isEmpty())
                    num=0;
                else{
                    num = Integer.parseInt(number.getText().toString());

                    Intent intent=new Intent(DependsOnAnotherActivity.this,SquareCalculator.class);
                    intent.putExtra("number",num);
                    startActivityForResult(intent,50);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){
            int result=data.getIntExtra("result",0);


            ((TextView)findViewById(R.id.tvNumber)).setText("Result: "+result);

            findViewById(R.id.btnSquare).setVisibility(View.GONE);
            findViewById(R.id.etNumber).setVisibility(View.GONE);
        }
    }
}
