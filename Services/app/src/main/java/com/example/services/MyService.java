package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyService extends Service
{
    Random random;
    boolean flag;
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    { return null; }
    @Override
    public void onCreate() {
        super.onCreate();
        random=new Random();
        flag=true;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(flag)
                {
                    int number=random.nextInt(100);
                    Log.i("Service onStartCommand","Random Number: "+number);
                    try {
                        Thread.sleep(1000);
                    } catch(Exception e){}
                }
                Log.i("Service onStartCommand","Service Thread Id: "+Thread.currentThread().getId());
            }
        }).start();
        return START_STICKY;
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        flag=false;
    }
}