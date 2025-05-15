package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb, edtketqua;
    Button btntong, btnclear;
    TextView tvlichsu;

    String lichsu = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtketqua = findViewById(R.id.edtketqua);
        btntong = findViewById(R.id.btntong);
        btnclear = findViewById(R.id.btnclear);
        tvlichsu = findViewById(R.id.tvlichsu);

        //đọc lại dl đã lưu trong SP
        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        lichsu = mypref.getString("ls","");
        tvlichsu.setText(lichsu); //hien thi

        //xử lý click
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dl
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int kq = a + b;
                //hiển thị kq
                edtketqua.setText(kq + "");
                lichsu += a + "+" + b + "=" + kq;
                tvlichsu.setText(lichsu);
                //xuống dòng
                lichsu += "\n";
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set lại rỗng
                lichsu = "";
                tvlichsu.setText(lichsu);

            }
        });
        }

    //lưu trữ dl

    @Override
    protected void onPause() {
        super.onPause();
        //4 bước lưu trữ dl
        //tạo đối tượng sp
        SharedPreferences mypref = getSharedPreferences("mysave", MODE_PRIVATE);
        //tạo đối tượng editor
        SharedPreferences.Editor myedit = mypref.edit();
        //lưu dl
        myedit.putString("ls",lichsu);
        //xác nhận lưu trữ
        myedit.commit();

    }
}