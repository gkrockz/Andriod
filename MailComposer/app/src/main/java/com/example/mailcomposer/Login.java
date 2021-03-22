package com.example.mailcomposer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btnobj;
    EditText uname,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnobj= findViewById(R.id.signin);
        uname = findViewById(R.id.et1);
        pass = findViewById(R.id.et2);
        btnobj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String usrname,password;
        Intent obj = new Intent(this,MainActivity.class);
        usrname = uname.getText().toString();
        password = pass.getText().toString();
        obj.putExtra("usr_name",usrname);
        startActivity(obj);
    }
}

