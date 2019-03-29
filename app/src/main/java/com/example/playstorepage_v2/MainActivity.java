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

    private int filledStarId;
    private int emptyStarId;
    private TypedArray ratingStars;

    private void displayButtonName(String name) {
        String snackbarMessage = "You just clicked on a button: " + name;
        View mainView = findViewById(R.id.mainView);
        Snackbar snackbar = Snackbar.make(mainView,snackbarMessage,Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private void updateRatingBar(int rating){
        int n = ratingStars.length();
        for(int i=0;i<=rating;i++){
            ImageView star = findViewById(ratingStars.getResourceId(i,-1));
            star.setImageResource(filledStarId);
        }
        for(int i=rating+1;i<=n;i++){
            ImageView star = findViewById(ratingStars.getResourceId(i,-1));
            star.setImageResource(emptyStarId);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingStars = getResources().obtainTypedArray(R.array.ratingStarImages);
        emptyStarId = R.drawable.icons8_star_500;
        filledStarId = R.drawable.icons8_star_filled_500;

        addButtonListeners();
        addRatingBarListeners();
    }




    private void addButtonListeners() {
        findViewById(R.id.uninstallButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayButtonName("UNINSTALL");
            }
        });

        findViewById(R.id.openButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayButtonName("OPEN");
            }
        });
        findViewById(R.id.travelAndLocalButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayButtonName("Travel & Local");
            }
        });

        findViewById(R.id.similarButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayButtonName("Similar");
            }
        });

        findViewById(R.id.readMoreButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayButtonName("READ MORE");
            }
        });
    }

    private void addRatingBarListeners() {
        int n = ratingStars.length();
        for(int i=0;i<n;i++){
            final int j = i;
            findViewById(ratingStars.getResourceId(i,-1)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateRatingBar(j);
                }
            });
        }
    }
}
