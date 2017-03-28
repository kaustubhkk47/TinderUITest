package com.wholdus.tinderuitest.HomeScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.wenchao.cardstack.CardStack;
import com.wholdus.tinderuitest.R;

import java.util.ArrayList;

public class AndroidSwipeableCardStackActivity extends AppCompatActivity {

    CardStack mCardStack;
    CardsDataAdapter adapter;
    ArrayList testData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_swipeable_card_stack);

        mCardStack = (CardStack) findViewById(R.id.swipe_deck);

        testData = new ArrayList<>();
        testData.add("@drawable/product_image_1");
        testData.add("@drawable/product_image_2");

        //choose your favorite adapter
        adapter = new CardsDataAdapter(testData, this, 0);

        if(mCardStack != null){
            mCardStack.setAdapter(adapter);
        }

        YourListener yourListener;
        yourListener = new YourListener(){
            @Override
            public boolean swipeEnd(int direction, float distance) {
                //if "return true" the dismiss animation will be triggered
                //if false, the card will move back to stack
                //distance is finger swipe distance in dp

                //the direction indicate swipe direction
                //there are four directions
                //  0  |  1
                // ----------
                //  2  |  3

                return (distance>300)? true : false;
            }

            @Override
            public boolean swipeStart(int direction, float distance) {

                return true;
            }

            @Override
            public boolean swipeContinue(int direction, float distanceX, float distanceY) {

                return true;
            }

            @Override
            public void discarded(int id, int direction) {
                addDataToAdapter();
            }

            @Override
            public void topCardTapped() {
                //this callback invoked when a top card is tapped by user.
            }
        };

        mCardStack.setListener(yourListener);

        // Optionally add an OnItemClickListener
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardStack.discardTop(0);
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCardStack.discardTop(1);
            }
        });

    }

    public void addDataToAdapter(){
        if ((testData.get(testData.size()-1)).equals("@drawable/product_image_1")){
            testData.add("@drawable/product_image_2");
        } else{
            testData.add("@drawable/product_image_1");
        }
        //testData.remove(0);
        adapter.notifyDataSetChanged();
    }

}


