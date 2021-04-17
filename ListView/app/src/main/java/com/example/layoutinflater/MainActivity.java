package com.example.layoutinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] titles = {"Red","Chuck","Blues","Mighty Eagle","Hatchlings","Matilda","Stella","Terence","Loenard"};
    int[] images = {R.drawable.red, R.drawable.chuck, R.drawable.blues,R.drawable.eagle, R.drawable.hatchlings, R.drawable.matilda,R.drawable.stella, R.drawable.terence, R.drawable.pigs};
    String[] subtitle = {"Angriest Bird", "No Filter", "Three of a kind", "Total Legend", "Freshly hatched", "Hippie of the Flock", "Feisty Optimist", "Really Big", "Bad Piggies"};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = findViewById(R.id.lv1);
        CustomAdapter adapter = new CustomAdapter(this, titles, images, subtitle);
        l.setAdapter(adapter);

    }
}