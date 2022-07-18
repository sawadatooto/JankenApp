package com.example.jankenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BattleActivity extends AppCompatActivity {
    final int JANKEN_GU = 0;
    final int JANKEN_CHOKI = 1;
    final int JANKEN_PA = 2;
    int subResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        int comHand = (int)(Math.random() * 3);
        ImageView comHandImageView = (ImageView)findViewById(R.id.npc);
        switch (comHand) {
            case JANKEN_GU:
                comHandImageView.setImageResource(R.drawable.janken_npc_gu);
                break;
            case JANKEN_CHOKI:
                comHandImageView.setImageResource(R.drawable.janken_npc_choki);
                break;
            case JANKEN_PA:
                comHandImageView.setImageResource(R.drawable.janken_npc_pa);
                break;
        }

        TextView resultLabel = (TextView)findViewById(R.id.starttext);
        int gameResult = (comHand - myHand + 3) % 3;
        switch (gameResult) {
            case 0:
                resultLabel.setText(R.string.result_draw); /*引き分けの場合*/
                break;
            case 1:
                subResult = 1; /*勝った場合*/
                break;
            case 2:
                subResult = 0; /*負けた場合*/
                break;
        }
    }

    int myHand = 0;
    ImageView myHandImageView = (ImageView)findViewById(R.id.player);
    public void gu(View view) {
        myHandImageView.setImageResource(R.drawable.janken_player_gu);
        myHand = JANKEN_GU;
    }

    public void choki(View view) {
        myHandImageView.setImageResource(R.drawable.janken_player_choki);
        myHand = JANKEN_CHOKI;
    }

    public void pa(View view) {
        myHandImageView.setImageResource(R.drawable.janken_player_pa);
        myHand = JANKEN_PA;
    }

    public void atack() {
        if(subResult == 1) {

        }
    }

    public void guard() {

    }

    private int getHand() {
        int hand = (int) (Math.random() * 3);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        int gameCount = pref.getInt("GAME_COUNT", 0);
        int winningStreakCount = pref.getInt("WINNING_STREAK_COUNT", 0);
        int lastMyHand = pref.getInt("LAST_MY_HAND", 0);
        int lastComHand = pref.getInt("LAST_COM_HAND", 0);
        int beforeLastComHand = pref.getInt("BEFORE_LAST_COM_HAND", 0);
        int gameResult = pref.getInt("GAME_RESULT", -1);

        if (gameCount == 1) {
            if (gameResult == 2) {
                while (lastComHand == hand) {
                    hand = (int) (Math.random() * 3);
                }
            } else if (gameResult == 1) {
                hand = (lastMyHand - 1 + 3) % 3;
            }
        } else if (winningStreakCount > 0) {
            if (beforeLastComHand == lastComHand) {
                while (lastComHand == hand) {
                    hand = (int) (Math.random() * 3);
                }
            }
        }
        return hand;
    }
}