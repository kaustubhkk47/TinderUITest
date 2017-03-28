package com.wholdus.tinderuitest.HomeScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.wholdus.tinderuitest.R;

import java.util.ArrayList;

public class SwipeDeck2Activity extends AppCompatActivity {

    ArrayList testData;
    SwipeDeck cardStack;
    SwipeDeck2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_deck2);

        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);

        testData = new ArrayList<>();
        testData.add("@drawable/product_image_1");
        testData.add("@drawable/product_image_2");

        adapter = new SwipeDeck2Adapter(testData, this);

        if(cardStack != null){
            cardStack.setAdapter(adapter);
        }

        cardStack.setCallback(new SwipeDeck.SwipeDeckCallback() {
            @Override
            public void cardSwipedLeft(long l) {
                addDataToAdapter();
            }
            @Override
            public void cardSwipedRight(long l) {
                addDataToAdapter();
            }
        });

        cardStack.setLeftImage(R.id.left_image);
        cardStack.setRightImage(R.id.right_image);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStack.swipeTopCardLeft(180);
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStack.swipeTopCardRight(180);
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
