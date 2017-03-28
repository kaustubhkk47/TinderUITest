package com.wholdus.tinderuitest.HomeScreen;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;
import com.wholdus.tinderuitest.R;

import java.util.ArrayList;

public class SwipeableCardsActivity extends AppCompatActivity {
    CardContainer mCardContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipeable_cards2);

        mCardContainer = (CardContainer) findViewById(R.id.swipe_deck);

        Resources r = getResources();

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

        CardModel card = new CardModel("Title1", "Description goes here", r.getDrawable(R.drawable.product_image_1));

        card.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                addDataToAdapter();
            }

            @Override
            public void onDislike() {
                addDataToAdapter();
            }
        });

        adapter.add(card);
        mCardContainer.setAdapter(adapter);

    }

    public void addDataToAdapter(){
    }
}
