package com.gaadi.dagger.junit.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.dagger.junit.model.DataObject;
import com.gaadi.dagger.junit.R;
import com.gaadi.dagger.junit.ui.activity.SimpleListActivity;
import com.gaadi.dagger.junit.ui.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by vinodtakhar on 2/12/15.
 */
public class RecyclerViewFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.my_recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new
          MyRecyclerViewAdapter.MyClickListener() {
              @Override
              public void onItemClick(int position, View v) {

                  startActivity(new Intent(getActivity(), SimpleListActivity.class));
              }
          });
    }

    private ArrayList<DataObject> getDataSet() {
        ArrayList results = new ArrayList<DataObject>();
        for (int index = 0; index < 20; index++) {
            DataObject obj = new DataObject("Some Primary Text " + index,
                    "Secondary " + index);
            results.add(index, obj);
        }
        return results;
    }
}
