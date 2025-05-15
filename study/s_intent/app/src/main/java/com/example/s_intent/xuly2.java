package com.example.s_intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class xuly2 extends AppCompatActivity {
    EditText edtAA;
    Button btngoc;
    Button btnbp;
    Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuly2);

        //ánh xạ id
        edtAA = findViewById(R.id.edtAA);
        btngoc = findViewById(R.id.btngoc);
        btnbp = findViewById(R.id.btnbp);
        //nhận intent
        myintent = getIntent();
        //lây dữ liệu khỏi intent
        int a=myintent.getIntExtra("soa",0);
        //hiển thị a
        edtAA.setText(a+"");

        //xử lý click cho button gốc
        btngoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq", a);
                //trả kết quả
                setResult(33, myintent);
                //thoát activity
                finish();
            }
        });

        //xử lý click cho button bình phương
        btnbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq", a*a);
                //trả kết quả
                setResult(34, myintent);
                //thoát activity
                finish();
            }
        });
        }

    }
