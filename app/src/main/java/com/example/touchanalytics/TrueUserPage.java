package com.example.touchanalytics;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TrueUserPage extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.true_user);


        Button backBtn = findViewById(R.id.no_Success_returnToMain);
        backBtn.setText("No, return to the main page");
        backBtn.setOnClickListener(view -> {
            Intent backToMain = new Intent(view.getContext(), MainActivity.class);
            startActivity(backToMain);
        });
        Button contBtn = findViewById(R.id.yes_Success);
        contBtn.setText("Yes, I want to continue");
        contBtn.setOnClickListener(view -> {
            Intent backToMain = new Intent(view.getContext(), MainActivity.class);
            startActivity(backToMain);
        });
    }
}



