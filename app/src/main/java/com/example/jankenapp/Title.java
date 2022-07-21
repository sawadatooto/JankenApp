package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button rankButton = (Button) findViewById(R.id.Rankbutton);
        rankButton.setVisibility(View.INVISIBLE);
    }
    public void onStartButtonTapped(View view){
        Intent intent = new Intent(this, Difficulty2.class);
        startActivity(intent);
    }
    public void onRuleButton(View view){
        Intent intent = new Intent(this, Rule2.class);
        startActivity(intent);
    }

    public void onRankButton(View view){
        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }
}