package com.example.s_intent;


import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result  extends AppCompatActivity {
    TextView txtresult;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_a);
        //ánh xạ
        txtresult = findViewById(R.id.txtresult);
        btnback = findViewById(R.id.btnback);
        //nhận intent
        Intent myintent = getIntent();
        //lấy bundle từ intent
        Bundle mybundle = myintent.getBundleExtra("mypackage");
        //lấy dữ liệu từ bundle
        int a = mybundle.getInt("soa");
        int b = mybundle.getInt("sob");
        //tiến hành giải pt
        String nghiem = "";
        if (a == 0 && b == 0)
            nghiem = "Vô số nghiệm";
        else if (a == 0 && b != 0)
            nghiem ="Vô nghiệm";
        else
            nghiem ="x = " + (-b / a);
        txtresult.setText(nghiem);
        //xử lý click
        btnback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            finish();
            }
        });

    }
}