package com.example.touchanalytics;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

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

        Button imageBtn = findViewById(R.id.testImages);
        imageBtn.setOnClickListener(view -> {
            setContentView(R.layout.calibration);
            ImageView imgView;
            imgView = findViewById(R.id.calibrationImgView);
            char animalChar;

            for( int i = 0; i < 4; i++ ){
                if (i == 0)
                {
                    animalChar = 'c';
                    //animalStr = "cats";
                }
                else if (i == 1)
                {
                    animalChar = 'd';
                    //animalStr = "dogs";
                }
                else if (i == 2)
                {
                    animalChar = 'b';
                }
                else
                {
                    animalChar = 'h';
                }
                for (int j = 0; j < 20; j++) {
                    String pathName = animalChar + "" + j;
                    Resources resources = this.getResources();
                    int id = resources.getIdentifier(pathName,"drawable", this.getPackageName());

                try {
                    imgView.setImageDrawable(resources.getDrawable(id, this.getTheme()));
                }
                catch(Exception e){
                    Log.d("", pathName);
                    }
                }

            }


        });


    }
}
