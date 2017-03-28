package com.wholdus.tinderuitest.HomeScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.daprlabs.aaron.swipedeck.SwipeDeck;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.wholdus.tinderuitest.R;

import java.util.ArrayList;

public class SwipecardsActivity extends AppCompatActivity {

    ArrayList testData;
    SwipeDeck2Adapter adapter;
    SwipeFlingAdapterView flingContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipecards);

        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.swipe_deck);

        testData = new ArrayList<>();
        testData.add("@drawable/product_image_1");
        testData.add("@drawable/product_image_2");

        //choose your favorite adapter
        adapter = new SwipeDeck2Adapter(testData, this);

        if(flingContainer != null){
            flingContainer.setAdapter(adapter);
        }

        //set the listener and the adapter
        flingContainer.setAdapter(adapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                testData.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                addDataToAdapter();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                addDataToAdapter();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
            }
            @Override
            public void onScroll(float itemsInAdapter) {
            }
        });

        // Optionally add an OnItemClickListener
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingContainer.getTopCardListener().selectLeft();
            }
        });
        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingContainer.getTopCardListener().selectRight();
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
