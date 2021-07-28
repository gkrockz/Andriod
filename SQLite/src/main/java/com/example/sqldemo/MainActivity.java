package com.example.sqldemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText id,name;
    Button ins,del,upd,read;
    String bid,bname;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Passing the current class instance to Helper class
        MyDbHelper obj = new MyDbHelper(this);
        obj.insert("1","Wanted Man");
        obj.delete("1");

        id = findViewById(R.id.bookid);
        name = findViewById(R.id.bookname);
        ins = findViewById(R.id.insert);
        del = findViewById(R.id.delete);
        upd = findViewById(R.id.update);
        read = findViewById(R.id.read);

        ins.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                bid =  id.getText().toString();
                bname = name.getText().toString();
                obj.insert(bid,bname);
            }

        });
        del.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                bid =  id.getText().toString();
                obj.delete(bid);
            }
        });
        upd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
            }
        });
        read.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                bname = name.getText().toString();
                obj.read(bname);
            }
        });

    }
}

