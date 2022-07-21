package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


public class Rule2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule2);
        ruleImageSwitcher = (ImageSwitcher) findViewById(R.id.ruleView);
        ruleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setImageResource(R.drawable.rule0);
                return imageView;
            }
        });
        Button nextButton = (Button) findViewById(R.id.nextButton);
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setVisibility(View.INVISIBLE);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backButton.setVisibility(View.VISIBLE);
                movePosition(1);
                if (ruleSlide == ruleImageResources.length - 1) {
                    nextButton.setVisibility(View.INVISIBLE);
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton.setVisibility(View.VISIBLE);
                movePosition(-1);
                if (ruleSlide == 0) {
                    backButton.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    ImageSwitcher ruleImageSwitcher;
    int[] ruleImageResources = { R.drawable.rule0, R.drawable.rule1, R.drawable.rule2};

    int ruleSlide = 0;
    private void movePosition(int move) {
        ruleSlide = ruleSlide + move;
        if (ruleSlide >= ruleImageResources.length) {
            ruleSlide = 2;
        } else if (ruleSlide < 0) {
            ruleSlide = 0;
        }
        ruleImageSwitcher.setImageResource(ruleImageResources[ruleSlide]);
    }
    public void onTitleBackTapped(View view){
        finish();
    }
    public void onStartButtonTapped(View view){
        Intent intent = new Intent(this, Difficulty2.class);
        startActivity(intent);
    }
}