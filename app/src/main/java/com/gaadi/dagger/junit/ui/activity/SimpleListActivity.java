package com.gaadi.dagger.junit.ui.activity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gaadi.dagger.junit.R;

import java.util.ArrayList;

/**
 * Created by vinodtakhar on 21/12/15.
 */
public class SimpleListActivity extends ListActivity{
    public void onCreate(Bundle bundle){

        super.onCreate(bundle);

        setContentView(R.layout.layout_list);


        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getListData()));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        startActivity(new Intent(this, AutoCompleteActivity.class));
    }

    private ArrayList<String> getListData(){
        ArrayList<String> list=new ArrayList<String>();

        for(int i=0;i<=200;i++)
            list.add("Item "+i);

        return list;
    }
}
