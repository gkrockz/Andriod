package com.example.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Button start,stop;
    Intent intent1,intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.demo);
        stop = findViewById(R.id.b2);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        Log.i("Activity onCreate", "Thread Id" + Thread.currentThread().getId());
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.demo:
                    intent1 = new Intent(this,MyService.class);
                    startService(intent1);
                    break;
            case R.id.b2:
                    intent2 = new Intent(this,MyService.class);
                    stopService(intent2);
                    break;
        }
    }
}