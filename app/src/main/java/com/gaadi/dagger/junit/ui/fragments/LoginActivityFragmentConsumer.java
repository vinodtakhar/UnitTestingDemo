package com.gaadi.dagger.junit.ui.fragments;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gaadi.dagger.junit.R;
import com.gaadi.dagger.junit.ui.activity.LoginResultActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragmentConsumer extends Fragment {

    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_login_consumer, container, false);

        btnLogin = (Button)view.findViewById(R.id.btnLogin);

        etUsername = (EditText)view.findViewById(R.id.etUserame);
        etPassword = (EditText)view.findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isDataValid()){
                    Bundle bundle=new Bundle();
                    bundle.putString("username",etUsername.getText().toString());
                    bundle.putString("password",etPassword.getText().toString());


                    Intent intent  =new Intent(getActivity(),LoginResultActivity.class);
                    intent.putExtras(bundle);

                    startActivity(intent);

                    getActivity().finish();
                }
                else
                {
//                    Toast.makeText(getActivity(),"data is snot valid.",Toast.LENGTH_SHORT).show();

                    if(etUsername.getText().toString().isEmpty())
                        etUsername.setError("Username is not valid");
                    else
                        etPassword.setError("Password is not valid");
                }
            }
        });

        return view;
    }

    private boolean isDataValid(){
        if(etUsername.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty())
            return false;
        else
            return true;
    }
}
