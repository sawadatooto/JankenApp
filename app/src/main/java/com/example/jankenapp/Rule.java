package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class Rule extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);
        ruleImageSwitcher = findViewById(R.id.ruleView);
        ruleImageSwitcher.setFactory(() -> new ImageView(getApplicationContext()));
        Button tapButton = findViewById(R.id.nextButton);
    }

    ImageSwitcher ruleImageSwitcher;
    int[] ruleImageResources = { R.drawable.rule0, R.drawable.rule1, R.drawable.rule2};

    int ruleSlide = 0;
    private void movePosition(int move) {
        ruleSlide = ruleSlide + 1;
        if (ruleSlide >= ruleImageResources.length) {
            ruleSlide = 0;
        } else if (ruleSlide < 0) {
            ruleSlide = ruleImageResources.length -1;
        }
        ruleImageSwitcher.setImageResource(ruleImageResources[ruleSlide]);
    }
    public void next(View v) {
        movePosition(1);
    }
    public void back(View v) {
        movePosition(-1);
    }
}