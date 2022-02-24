package com.example.touchanalytics;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntruderPage extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.failure_page);


        Button backBtn = findViewById(R.id.returnAfterFailure);
        backBtn.setText("Return to User Page");
        backBtn.setOnClickListener(view -> {
            Intent backToMain = new Intent(view.getContext(), MainActivity.class);
            startActivity(backToMain);
        });
    }
}
