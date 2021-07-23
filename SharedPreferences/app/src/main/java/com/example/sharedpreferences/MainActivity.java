package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private EditText uname,pwd;
    private Button login;
    private CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.editText);
        pwd=findViewById(R.id.editText2);
        login=findViewById(R.id.button);
        check=findViewById(R.id.checkBox);

        preferences=getSharedPreferences("com.example.sharedpreferencesdata",Context.MODE_PRIVATE);
        editor=preferences.edit();
        checkPreferences();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check.isChecked()){
                    editor.putString("state","True");
                    editor.putString("name",uname.getText().toString());
                    editor.putString("pwd",pwd.getText().toString());
                    editor.commit();
                }else
                {
                    editor.putString("state","False");
                    editor.putString("name","");
                    editor.putString("pwd","");
                    editor.commit();
                }
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void checkPreferences(){
        String checkBox=preferences.getString("state","False");
        String userName=preferences.getString("name","");
        String password=preferences.getString("pwd","");
        uname.setText(userName);
        pwd.setText(password);
        if(checkBox=="True"){
            check.setChecked(true);
        }else{
            check.setChecked(false);
        }
    }
}