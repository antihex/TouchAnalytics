package com.example.touchanalytics;

import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;


public class deleteUser extends MainActivity {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //TODO Make work

        super.onCreate(savedInstanceState);

        dataManager = new AnalyticDataManager(this, allRegisteredUserFiles);

        int size = display.widthPixels;
        int padding = 20;
        int btnSize = size/3 - (padding*2);
        GridLayout gridLayout = findViewById(R.id.idGrid);

        for(int i = 0; i < currentNumRegUsers; i++) {
            Button btn = new Button(this);
            String fileNameWEXT = allRegisteredUserFiles[i].getName();
            String usrTag = fileNameWEXT.substring(0, fileNameWEXT.indexOf('.'));
            Log.d("", usrTag);
            btn.setTag(usrTag);
            btn.setText(usrTag);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.height = btnSize;
            layoutParams.width = btnSize;
            layoutParams.setMargins(padding, padding, padding, padding);
            btn.setBackground(getResources().getDrawable(R.drawable.round_button));
            btn.setLayoutParams(layoutParams);
            gridLayout.addView(btn);

            int finalI = i;
            btn.setOnClickListener(view -> {
                Intent testSwipe = new Intent(view.getContext(), TestSwipe.class);
                Bundle bundle = new Bundle();
                dataManager.selectedUserIndex = finalI;
                bundle.putParcelable("dataManager", dataManager);
                testSwipe.putExtras(bundle);
                startActivity(testSwipe);
            });
        }
    }
}
