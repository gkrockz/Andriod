package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class    MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText num1,num2;
    Button addbtn,subbtn,mulbtn,divbtn;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fetching The View Of All Elements Through Resource Id.
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        addbtn = findViewById(R.id.add);
        subbtn = findViewById(R.id.sub);
        mulbtn = findViewById(R.id.mul);
        divbtn = findViewById(R.id.div);
        res = findViewById(R.id.result);

        // Registering All Buttons To EventHandler To Trigger Event Handler Code
        addbtn.setOnClickListener(this);
        subbtn.setOnClickListener(this);
        mulbtn.setOnClickListener(this);
        divbtn.setOnClickListener(this);
    }
    // Event Handler Code
    @Override
    public void onClick(View v)
    {
        int a,b;
        if(v.getId()==R.id.add)
        {
             a = Integer.parseInt(num1.getText().toString());
             b = Integer.parseInt(num2.getText().toString());
             int result = a+b;
            res.setText("Addition Result : "+Integer.toString(result));
        }
        else if(v.getId()==R.id.sub)
        {     a = Integer.parseInt(num1.getText().toString());
              b = Integer.parseInt(num2.getText().toString());
              int result = a-b;
              res.setText("Subtraction Result : "+Integer.toString(result));
        }
        else if(v.getId()==R.id.mul)
        {    a = Integer.parseInt(num1.getText().toString());
             b = Integer.parseInt(num2.getText().toString());
             int result  = a*b;
            res.setText("Multiplication Result : "+Integer.toString(result));
        }
        else if(v.getId()==R.id.div)
        {     a = Integer.parseInt(num1.getText().toString());
              b = Integer.parseInt(num2.getText().toString());
              double result = a / (b*1.0);
            res.setText("Division Result : "+Double.toString(result));
        }
        else {
            res.setText(String.valueOf("Please Select Valid Operation"));
        }
    }
}