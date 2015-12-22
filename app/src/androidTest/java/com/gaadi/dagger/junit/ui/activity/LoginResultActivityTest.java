package com.gaadi.dagger.junit.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.gaadi.dagger.junit.R;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by vinodtakhar on 4/12/15.
 */
public class LoginResultActivityTest extends ActivityInstrumentationTestCase2<LoginResultActivity> {

    private LoginResultActivity mActivity;

    public LoginResultActivityTest() {
        super(LoginResultActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

    }

    @Test
    public void testControlsVisibilityOnFailure(){
        Bundle bundle =new Bundle();
        bundle.putString("username","vinod");
        bundle.putString("password", "adfasdf");

        Intent intent= new Intent(getInstrumentation().getContext(),LoginResultActivity.class);
        intent.putExtras(bundle);

        setActivityIntent(intent);

        mActivity=getActivity();

        assertEquals(true, mActivity.findViewById(R.id.tvUsername).getVisibility() == View.GONE);
        assertEquals(true, mActivity.findViewById(R.id.tvPassword).getVisibility() == View.GONE);

        Utility.wait2Seconds();

        mActivity.finish();
    }

    @Test
    public void testControlsVisibilityOnSuccess(){
        Bundle bundle =new Bundle();
        bundle.putString("username","vinod");
        bundle.putString("password", "vinod");

        Intent intent= new Intent(getInstrumentation().getContext(),LoginResultActivity.class);
        intent.putExtras(bundle);

        setActivityIntent(intent);

        mActivity=getActivity();

        assertEquals(true, mActivity.findViewById(R.id.tvUsername).getVisibility() == View.VISIBLE);
        assertEquals(true,mActivity.findViewById(R.id.tvPassword).getVisibility()== View.VISIBLE);

        Utility.wait2Seconds();

        mActivity.finish();
    }



    public void tearDown() throws Exception {

    }
}