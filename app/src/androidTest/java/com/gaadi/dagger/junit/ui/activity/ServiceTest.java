package com.gaadi.dagger.junit.ui.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.test.ServiceTestCase;
import android.util.Log;

import com.gaadi.dagger.junit.ui.services.MyService;

import org.junit.Rule;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.assertTrue;

/**
 * Created by vinodtakhar on 22/12/15.
 */
public class ServiceTest{
    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule(){
//        @Override
//        public void startService(Intent intent) throws TimeoutException {
//            super.startService(intent);
//        }
//
//        @Override
//        protected void beforeService() {
//            super.beforeService();
//        }
//
//        @Override
//        protected void afterService() {
//            super.afterService();
//        }
    };

    @Test
    public void testService(){
        try {
            mServiceRule.startService(
                    new Intent(InstrumentationRegistry.getTargetContext(), MyService.class));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        assertTrue(isServiceRunning());

        //get binder and test method calls
    }

    private boolean isServiceRunning() {
        final ActivityManager activityManager = (ActivityManager)InstrumentationRegistry.getTargetContext().getSystemService(Context.ACTIVITY_SERVICE);

        final List<ActivityManager.RunningServiceInfo> services = activityManager
                .getRunningServices(Integer.MAX_VALUE);

        boolean serviceFound = false;
        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
//            Log.e("Test", "" + runningServiceInfo.service.getClassName());
            if (runningServiceInfo.service.getClassName().equals("com.gaadi.dagger.junit.ui.services.MyService"
                    /*MyService.class.toString()*/)) {
                serviceFound = true;
            }
        }
        return serviceFound;
    }


}
