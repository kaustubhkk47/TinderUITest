package com.wholdus.tinderuitest.HomeScreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.wholdus.tinderuitest.R;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SwipeDeck2Button = (Button) findViewById(R.id.SwipeDeck2Button);
        Button SwipecardsButton = (Button) findViewById(R.id.SwipecardsButton);
        Button Swipeable_CardsButton = (Button) findViewById(R.id.SwipeableCardsButton);
        Button AndroidSwipeableCardStackButton = (Button) findViewById(R.id.AndroidSwipeableCardStackButton);

        Swipeable_CardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = getApplicationContext();
                Intent intent = new Intent(mContext, SwipeableCardsActivity.class);
                startActivity(intent);
            }
        });

        AndroidSwipeableCardStackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = getApplicationContext();
                Intent intent = new Intent(mContext, AndroidSwipeableCardStackActivity.class);
                startActivity(intent);
            }
        });

        SwipecardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = getApplicationContext();
                Intent intent = new Intent(mContext, SwipecardsActivity.class);
                startActivity(intent);
            }
        });

        SwipeDeck2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context mContext = getApplicationContext();
                Intent intent = new Intent(mContext, SwipeDeck2Activity.class);
                startActivity(intent);

            }
        });

        startTapTarget();


        new TapTargetSequence(this)
                .targets(
                        TapTarget.forView(findViewById(R.id.SwipeDeck2Button), "Gonna"),
                        TapTarget.forView(findViewById(R.id.SwipecardsButton), "You", "Up"))
                .listener(new TapTargetSequence.Listener() {
                    // This listener will tell us when interesting(tm) events happen in regards
                    // to the sequence
                    @Override
                    public void onSequenceFinish() {
                        Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSequenceCanceled(TapTarget lastTarget) {

                    }
                })
                .continueOnCancel(true)
                .start();

    }

    public void startTapTarget(){
        TapTargetView.showFor(this,
                TapTarget.forView(findViewById(R.id.SwipeDeck2Button),
                        "Title",
                        "Description").targetRadius(70),
                new TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);      // This call is optional
                        Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
