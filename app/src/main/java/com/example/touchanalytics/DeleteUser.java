package com.example.touchanalytics;

import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;


public class DeleteUser extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_user);
        int size = display.widthPixels;
        int padding = 20;
        int btnSize = size / 3 - (padding * 2);
        GridLayout gridLayout = findViewById(R.id.idGrid);


        for(int i = 0; i < MainActivity.currentNumRegUsers; i++){
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
            btn.setBackground(getResources().getDrawable(R.drawable.round_button2));
            btn.setLayoutParams(layoutParams);
            gridLayout.addView(btn);

            btn.setOnClickListener(view -> {
                OpenSaveCSV.deleteCSV(view.getContext(), usrTag);
                Intent goToMain = new Intent(view.getContext(), MainActivity.class);
                startActivity(goToMain);
            });
        }
        Button bckBtn = findViewById(R.id.backToMainBtn);
        bckBtn.setOnClickListener(view -> {
            Intent goToMain = new Intent(view.getContext(), MainActivity.class);
            startActivity(goToMain);
        });


    }
}

