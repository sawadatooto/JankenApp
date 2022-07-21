package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Difficulty2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty2);
        Button easyButton = (Button) findViewById(R.id.Easybutton);
        Button normalButton = (Button) findViewById(R.id.Normalbutton);
        Button hardButton = (Button) findViewById(R.id.Hardbutton);
        easyButton.setVisibility(View.INVISIBLE);
        normalButton.setVisibility(View.INVISIBLE);
        hardButton.setVisibility(View.INVISIBLE);
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