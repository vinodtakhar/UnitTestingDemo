package com.gaadi.dagger.junit.dagger;

import android.support.v4.app.Fragment;

import com.gaadi.dagger.junit.BuildConfig;
import com.gaadi.dagger.junit.ui.fragments.LoginActivityFragmentConsumer;
import com.gaadi.dagger.junit.ui.fragments.LoginActivityFragmentDealer;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vinodtakhar on 2/12/15.
 */
@Module
public class AppModule {

    @Provides
    Fragment provideLoginActivityFragment() {
        if(BuildConfig.APP_CLIENT.equals("dealer"))
            return new LoginActivityFragmentDealer();
        else
            return new LoginActivityFragmentConsumer();
    }

    @Provides
    ArrayList<String> provideAutoCompleteData(){
        ArrayList<String> list=new ArrayList<String>();

        if(BuildConfig.DEBUG)
        {
            for(int i=0;i<=300;i++)
                list.add("Test "+i);
        }
        else{
            for(int i=0;i<=300;i++)
                list.add("Actual "+i);
        }

        return list;
    }
}
