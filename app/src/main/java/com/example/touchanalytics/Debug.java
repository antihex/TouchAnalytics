package com.example.touchanalytics;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Debug extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_page);

        Button bckBtn = findViewById(R.id.backToMainBtn2);  //Back Button
        bckBtn.setOnClickListener(view -> {
            Intent goToMain = new Intent(view.getContext(), MainActivity.class);
            startActivity(goToMain);
        });

        //Button imageBtn = findViewById(R.id.testImages);    //Image Button
        //imageBtn.setOnClickListener(view -> {
        //    Intent debugImages = new Intent(view.getContext(), CollectSwipe.class);
        //    startActivity(debugImages);
        //});

        Button susBtn = findViewById(R.id.testImposter);    //Intruder Button
        susBtn.setOnClickListener(view -> {
            Intent debugImposter = new Intent(view.getContext(), IntruderPage.class);
            startActivity(debugImposter);
        });

        Button trueUserBtn = findViewById(R.id.testTrueUser);    //True User Button
        trueUserBtn.setOnClickListener(view -> {
            Intent debugTrueUser = new Intent(view.getContext(), TrueUserPage.class);
            startActivity(debugTrueUser);
        });

        Button caliBtn = findViewById(R.id.testCalibrationPage);    //Cali Button
        caliBtn.setOnClickListener(view -> {
            Intent debugCali = new Intent(view.getContext(), CalibrateUser.class);
            startActivity(debugCali);
        });


    }
}
