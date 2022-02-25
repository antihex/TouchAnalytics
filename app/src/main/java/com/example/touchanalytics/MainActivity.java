package com.example.touchanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;

import java.io.File;

public class MainActivity extends AppCompatActivity{

    AnalyticDataManager dataManager;
    int[] CSVIds;
    public static int currentNumRegUsers = 0;
    static File registeredUserSaveDir;
    File[] allRegisteredUserFiles;
    DisplayMetrics display;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        display = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(display);
        getSupportActionBar().hide();
        OpenSaveCSV.verifyStoragePermissions(this);
        File DCIMDir = this.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        File dataDCIMDir = new File(DCIMDir, "data");
        if (!dataDCIMDir.exists()){
            boolean worked = dataDCIMDir.mkdirs();
            if (!worked){ Log.d("", "somehow didn't work"); }
            Log.d("", "Making DCIM Data path");
        }
        registeredUserSaveDir = dataDCIMDir;
        allRegisteredUserFiles = CheckForRegisteredUsers();
        Log.d("", "allRegisteredUserFiles length: " + allRegisteredUserFiles.length);
        setContentView(R.layout.activity_main);


        //Intent openCSV = new Intent(this, OpenSaveCSV.class);
        //startActivity(openCSV);
        CSVIds = new int[]{
                R.raw.user0,
                R.raw.user1,
                R.raw.user2,
                R.raw.user3,
                R.raw.user4,
                R.raw.user5
        };



        Log.d("", "test 1");
        //dataManager = new AnalyticDataManager(this, CSVIds);
        dataManager = new AnalyticDataManager(this, allRegisteredUserFiles);
        Log.d("", "test 2");


        Button calibrateUSRBtn = findViewById(R.id.calibrateUSRBtn);



        calibrateUSRBtn.setOnClickListener(view -> {
            Intent swipeCollect = new Intent(view.getContext(), CollectSwipe.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("manager", dataManager);
            swipeCollect.putExtras(bundle);
            startActivity(swipeCollect);
        });

        Button deleteUSRBtn = findViewById(R.id.deleteUserBtn);

        deleteUSRBtn.setOnClickListener(view -> {
            //TODO Should a specified user or something
        });



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

    public static File[] CheckForRegisteredUsers(){
        File[] filesDCIM = registeredUserSaveDir.listFiles();
        int count = (filesDCIM != null) ? filesDCIM.length : -1;
        if (count == -1){
            Log.d("", "other uh oh");
            return null;
        }else{
            Log.d("", "count: " + count);
            currentNumRegUsers = count;
            return filesDCIM;
        }
    }
}