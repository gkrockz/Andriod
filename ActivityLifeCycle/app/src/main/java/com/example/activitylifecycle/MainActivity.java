package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("onCreate() Method called: ","Initialized All Variables And Views" );
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart() Method called: ","App Started And Visible To User");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onResume() Method called: ","User Interacts With The Activity Page");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause() Method called: "," App Is Partially Visible :");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(" onStop() called : ","App Is Not Visible " );
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onReStart() Method called : ","App Restarted From Background State.");
    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy() Method called : "," App Destroyed (Or) Closed From Main Memory ");
    }
}

