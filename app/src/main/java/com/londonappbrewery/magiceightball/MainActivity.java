package com.londonappbrewery.magiceightball;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button askButton = findViewById(R.id.askButton);
        final ImageView answerImage = findViewById(R.id.answerImage);
        final Random randomNumberGenerated = new Random();

        final int[] arrayAnswer = {
                R.drawable.yes,
                R.drawable.no,
                R.drawable.maybe,
                R.drawable.no_idea,
                R.drawable.yes_def
        };


        askButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                int number = randomNumberGenerated.nextInt(5);
                answerImage.setImageResource(arrayAnswer[number]);
            }
        });

        askButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    askButton.setBackgroundColor(Color.rgb(48, 63, 159));
                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    askButton.setBackgroundColor(Color.rgb(48, 81, 181));
                }
                return false;
            }
        });
    }
}
