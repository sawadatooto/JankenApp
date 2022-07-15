package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Title extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onStartButton(View view){
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }
    public void onRuleButton(View view){
        Intent intent = new Intent(this, Rule.class);
        startActivity(intent);
    }
    public void onRankButton(View view){
        Intent intent = new Intent(this, RankActivity.class);
        startActivity(intent);
    }
}