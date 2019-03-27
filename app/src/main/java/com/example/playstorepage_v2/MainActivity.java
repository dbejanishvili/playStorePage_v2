package com.example.playstorepage_v2;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button uninstallButton = (Button) findViewById(R.id.uninstallButton);
        uninstallButton.setOnClickListener(defaultButtonListener);
        final Button openButton = (Button) findViewById(R.id.openButton);
        openButton.setOnClickListener(defaultButtonListener);
        final Button travelAndLocalButton = (Button) findViewById(R.id.travelAndLocalButton);
        travelAndLocalButton.setOnClickListener(defaultButtonListener);
        final Button similarButton = (Button) findViewById(R.id.similarButton);
        similarButton.setOnClickListener(defaultButtonListener);
        final Button readMoreButton = (Button) findViewById(R.id.readMoreButton);
        readMoreButton.setOnClickListener(defaultButtonListener);
    }
}
