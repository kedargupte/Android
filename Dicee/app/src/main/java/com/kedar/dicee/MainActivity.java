package com.kedar.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.buttonRoll);
        final ImageView leftDice = (ImageView) findViewById(R.id.imageLeftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.imageRightDice);

        final int[] diceArray = new int[] {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();

                int number = random.nextInt(6);
                leftDice.setImageResource(diceArray[number]);

                number = random.nextInt(6);
                rightDice.setImageResource(diceArray[number]);

                Log.d("In click method", "!");
            }

        });
    }




}
