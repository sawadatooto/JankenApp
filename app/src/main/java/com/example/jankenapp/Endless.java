package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Random;

public class Endless extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endless);
        playerImageSwitcher = (ImageSwitcher) findViewById(R.id.player);
        playerImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setImageResource(R.drawable.janken_player1);
                return imageView;
            }
        });
        npcImageSwitcher = (ImageSwitcher) findViewById(R.id.npc);
        npcImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setImageResource(R.drawable.janken_npc);
                return imageView;
            }
        });
        atackButton.setVisibility(View.INVISIBLE);
        guardButton.setVisibility(View.INVISIBLE);

        guButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                playerImageSwitcher.setImageResource(playerImageResources[0]);
                handResult(0);
            }
        });
        chokiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                playerImageSwitcher.setImageResource(playerImageResources[1]);
                handResult(1);
            }
        });
        paButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                playerImageSwitcher.setImageResource(playerImageResources[2]);
                handResult(2);
            }
        });
        atackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subResult == 1) {
                    stop = System.currentTimeMillis() * 1000;
                    mainAtackResult(stop - start);
                }
            }
        });
        guardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop = System.currentTimeMillis() * 1000;
                    mainGuardResult(stop - start);
            }
        });
    }

    ImageButton guButton = (ImageButton) findViewById(R.id.guButton);/*こいつらが悪さをしてるみたい*/
    ImageButton chokiButton = (ImageButton) findViewById(R.id.chokiButton);
    ImageButton paButton = (ImageButton) findViewById(R.id.paButton);
    ImageButton atackButton = (ImageButton) findViewById(R.id.hummerButton);
    ImageButton guardButton = (ImageButton) findViewById(R.id.helmetButton);/*↑ここまで*/

    ImageSwitcher playerImageSwitcher;
    int[] playerImageResources = { R.drawable.janken_player_gu, R.drawable.janken_player_choki, R.drawable.janken_player_pa};
    ImageSwitcher npcImageSwitcher;
    int[] npcImageResources = { R.drawable.janken_npc_gu, R.drawable.janken_npc_choki, R.drawable.janken_npc_pa};

    TextView infoView = (TextView) findViewById(R.id.starttext);
    int subResult;
    long start,stop;
    public void handResult(int hand) {
        int npcHand = (int)(Math.random() * 3);
        switch (npcHand) {
            case 0:
                npcImageSwitcher.setImageResource(npcImageResources[0]);
                break;
            case 1:
                npcImageSwitcher.setImageResource(npcImageResources[1]);
                break;
            case 2:
                npcImageSwitcher.setImageResource(npcImageResources[2]);
                break;
        }
        int handresult = (npcHand - hand + 3) % 3;
        switch (handresult) {
            case 0:
                infoView.setText(R.string.result_draw); /*引き分けの場合*/
                break;
            case 1:
                subResult = 1; /*勝った場合*/
                atackButton.setVisibility(View.VISIBLE);
                guardButton.setVisibility(View.VISIBLE);
                guButton.setEnabled(false);
                chokiButton.setEnabled(false);
                paButton.setEnabled(false);
                start = System.currentTimeMillis() * 1000;
                break;
            case 2:
                subResult = 0; /*負けた場合*/
                atackButton.setVisibility(View.VISIBLE);
                guardButton.setVisibility(View.VISIBLE);
                guButton.setEnabled(false);
                chokiButton.setEnabled(false);
                paButton.setEnabled(false);
                start = System.currentTimeMillis() * 1000;
                break;
        }
    }

    float max = 1;
    float min = 1 / 2;
    public void mainAtackResult (long playertime) {
        float npctime = new Random().nextFloat() * (max - min);
        if ((float)playertime < npctime) {
            infoView.setText("あなたの勝ちです");
        } else if ((float)playertime >= npctime) {
            infoView.setText("防がれました");
            guButton.setEnabled(true);
            chokiButton.setEnabled(true);
            paButton.setEnabled(true);
        }
        atackButton.setVisibility(View.INVISIBLE);
        guardButton.setVisibility(View.INVISIBLE);
    }
    public void mainGuardResult (long playertime) {
        float npctime = new Random().nextFloat() * (max - min);
        if (npctime < (float)playertime) {
            infoView.setText("あなたの負けです");
            atackButton.setEnabled(false);
            guardButton.setEnabled(false);
        } else if (npctime >= (float)playertime) {
            infoView.setText("防御成功です");
            guButton.setEnabled(true);
            chokiButton.setEnabled(true);
            paButton.setEnabled(true);
        }
        atackButton.setVisibility(View.INVISIBLE);
        guardButton.setVisibility(View.INVISIBLE);
    }
}