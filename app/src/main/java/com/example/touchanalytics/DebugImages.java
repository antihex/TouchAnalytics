package com.example.touchanalytics;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;


public class DebugImages extends AppCompatActivity {

    ImageView imageView;
    TextView txtView;
    char animalChar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.calibration);


        imageView = findViewById(R.id.calibrationImgView);


        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                animalChar = 'c';
                //animalStr = "cats";
            } else if (i == 1) {
                animalChar = 'd';
                //animalStr = "dogs";
            } else if (i == 2) {
                animalChar = 'b';
            } else {
                animalChar = 'h';
            }
            for (int j = 1; j <= 21; j++) {
                String pathName = animalChar + "" + j;
                Resources resources = this.getResources();
                int id = resources.getIdentifier(pathName, "drawable", this.getPackageName());

                try {
                    imageView.setImageDrawable(resources.getDrawable(id, this.getTheme()));
                    TimeUnit.SECONDS.sleep(1);

                } catch (Exception e) {
                    Log.d("", pathName);
                }
            }

        }
    }
}
