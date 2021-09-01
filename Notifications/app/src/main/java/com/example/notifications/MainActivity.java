package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    Intent intent,intent1;
    String CHANNEL_ID = "Category1";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayNotification(View v)
    {

        intent = new Intent(this,PendingEventTask.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_ONE_SHOT);

        intent1 = new Intent(Intent.ACTION_DIAL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent1 = PendingIntent.getActivity(this,1,intent1,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder obj = new NotificationCompat.Builder(this,CHANNEL_ID);
        obj.setSmallIcon(R.drawable.sms);
        obj.setContentTitle("New Message");
        obj.setContentText("It's Raining");
        obj.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        obj.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        obj.setCategory(NotificationCompat.CATEGORY_MESSAGE);
        obj.setContentIntent(pendingIntent);
        obj.setAutoCancel(true);
        obj.addAction(0,"Explicit intent",pendingIntent);
        obj.addAction(0,"Implicit Intent",pendingIntent1);

        NotificationManagerCompat compat = NotificationManagerCompat.from(this);
        compat.notify(100,obj.build());
    }
}