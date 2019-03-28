package com.example.playstorepage_v2;

import android.content.res.TypedArray;
import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int filledStarId = R.drawable.icons8_star_filled_500;
    private int emptyStarId = R.drawable.icons8_star_500;
    private TypedArray ratingStars = getResources().obtainTypedArray(R.array.ratingStarImages);

    private View.OnClickListener defaultButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button but = (Button) v;
            String snackbarMessage = "you just clicked on a button " + but.getText();
            View mainView = findViewById(R.id.mainView);
            Snackbar snackbar = Snackbar.make(mainView,snackbarMessage,Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    };

    private void updateRatingBar(int rating){
        for(int i=0;i<=rating;i++){
            ImageView star = findViewById(ratingStars.getResourceId(i,-1));
            star.setImageResource(filledStarId);
        }
        for(int i=rating+1;i<=4;i++){
            ImageView star = findViewById(ratingStars.getResourceId(i,-1));
            star.setImageResource(emptyStarId);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButtonListeners();
        addRatingBarListeners();
    }

    private void addButtonListeners() {
        findViewById(R.id.uninstallButton).setOnClickListener(defaultButtonListener);
        findViewById(R.id.openButton).setOnClickListener(defaultButtonListener);
        findViewById(R.id.travelAndLocalButton).setOnClickListener(defaultButtonListener);
        findViewById(R.id.similarButton).setOnClickListener(defaultButtonListener);
        findViewById(R.id.readMoreButton).setOnClickListener(defaultButtonListener);
    }

    private void addRatingBarListeners() {
        findViewById(R.id.ratingStar1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRatingBar(0);
            }
        });
        findViewById(R.id.ratingStar2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRatingBar(1);
            }
        });
        findViewById(R.id.ratingStar3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRatingBar(2);
            }
        });
        findViewById(R.id.ratingStar4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRatingBar(3);
            }
        });
        findViewById(R.id.ratingStar5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateRatingBar(4);
            }
        });
    }
}
