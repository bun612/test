package com.example.listview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity  extends AppCompatActivity {
    TextView txt_subphone;
    @Override
    protected void onCreate(Bundle savedInstantceState){
        super.onCreate(savedInstantceState);
        setContentView(R.layout.activity_sub);
        txt_subphone = findViewById(R.id.txt_subphone);
        //nhan intent
        Intent myintent = getIntent();
        //lay du lieu
        String namephone = myintent.getStringExtra("name");
        txt_subphone.setText(namephone);
    }
}
