package com.example.services;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService
{
    public MyIntentService(String name)
    {
        super("IntentService");
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent)
    {
        synchronized (this) {
            int count = 0;
            while (count < 10) {
                try {
                    wait(1500);
                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
