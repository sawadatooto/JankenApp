package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty2);
    }
    public void onTitleBackTapped(View view){
        Intent intent = new Intent(this,Title.class);
        startActivity(intent);
    }

    public void onEndlessButton(View view){
        Intent intent = new Intent(this, Endless.class);
        startActivity(intent);
    }
}