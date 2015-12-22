package com.gaadi.dagger.junit.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.gaadi.dagger.junit.R;
import com.gaadi.dagger.junit.dagger.MyApplication;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by vinodtakhar on 21/12/15.
 */
public class AutoCompleteActivity extends AppCompatActivity{

    @Inject
    ArrayList<String> data;

    private AutoCompleteTextView autoCompleteTextView;

    public void onCreate(Bundle bundle){
        super.onCreate(bundle);

        setContentView(R.layout.auto_list);

        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.list);

        ((MyApplication)getApplication()).component().inject(this);

        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data));
    }
}
