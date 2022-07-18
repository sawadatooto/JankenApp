package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Difficulty2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty2);
    }
    public void onTitleBackTapped(View view){
        finish();
    }

    public void onDifficultyButton(View view){
        Intent intent = new Intent(this, BattleActivity.class);
        intent.putExtra("DIFFICULTY",view.getId());
        startActivity(intent);
    }
}