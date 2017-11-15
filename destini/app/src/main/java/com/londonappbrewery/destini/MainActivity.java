package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView storyView;
    Button buttonTop;
    Button buttonBottom;
    Button buttonRestart;
    Map<Integer, StoryState> clickHandler = new HashMap<>();
    StoryState currentState = new StoryState(null, null, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initClickHandler();
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyView = (TextView) findViewById(R.id.storyTextView);
        buttonTop = (Button) findViewById(R.id.buttonTop);
        buttonBottom = (Button) findViewById(R.id.buttonBottom);
        buttonRestart = (Button) findViewById(R.id.buttonRestart);

        reset();
    }

    public void onClickButtonTop(View v) {
        Log.d("Clicked", "Top : " + currentState.bottomButtonId);
            currentState = clickHandler.get(currentState.bottomButtonId);
            setView();
    }

    public void onClickButtonBottom(View v) {
        Log.d("Clicked", "Button : " + currentState.topButtonId);
            currentState = clickHandler.get(currentState.topButtonId);
            setView();
    }

    public void onClickRestart(View v) {
        reset();
    }

    private void reset() {
        currentState.setStoryId(R.string.T1_Story);
        currentState.setTopButtonId(R.string.T1_Ans1);
        currentState.setBottomButtonId(R.string.T1_Ans2);
        buttonRestart.setVisibility(View.INVISIBLE);
        buttonTop.setVisibility(View.VISIBLE);
        buttonBottom.setVisibility(View.VISIBLE);
        setView();
    }

    private void initClickHandler() {
        clickHandler.put(R.string.T1_Ans1,
                new StoryState(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2));
        clickHandler.put(R.string.T1_Ans2,
                new StoryState(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2));

        clickHandler.put(R.string.T2_Ans1,
                new StoryState(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2));
        clickHandler.put(R.string.T2_Ans2,
                new StoryState(R.string.T4_End, null, null));

        clickHandler.put(R.string.T3_Ans1,
                new StoryState(R.string.T6_End, null, null));
        clickHandler.put(R.string.T3_Ans2,
                new StoryState(R.string.T5_End, null, null));

    }

    private void setView() {
        storyView.setText(currentState.getStoryId());

        if(currentState.getBottomButtonId() == null) {
            buttonRestart.setVisibility(View.VISIBLE);
            buttonBottom.setVisibility(View.INVISIBLE);
        } else {
            buttonBottom.setText(currentState.getBottomButtonId());
        }

        if(currentState.getTopButtonId() == null) {
            buttonRestart.setVisibility(View.VISIBLE);
            buttonTop.setVisibility(View.INVISIBLE);
        } else {
            buttonTop.setText(currentState.getTopButtonId());
        }

    }

}
