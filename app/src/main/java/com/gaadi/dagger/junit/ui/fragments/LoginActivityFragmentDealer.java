package com.gaadi.dagger.junit.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.dagger.junit.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragmentDealer extends Fragment {

    public LoginActivityFragmentDealer() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_dealer, container, false);
    }
}
