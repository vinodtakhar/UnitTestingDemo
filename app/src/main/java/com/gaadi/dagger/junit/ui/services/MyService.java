package com.gaadi.dagger.junit.ui.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
//        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        new Thread(){
            public void run(){
                for(int i=0;i<100;i++) {
                    try{
                        sleep(1000);
                    }catch (Exception e){e.printStackTrace();}

                    System.out.println(i);
                }
            }
        }.start();

        return Service.START_STICKY;
    }
}
