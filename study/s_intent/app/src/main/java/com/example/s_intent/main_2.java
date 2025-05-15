package com.example.s_intent;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class main_2 extends AppCompatActivity {
    EditText edta;
    EditText edtkq;
    Button btnrequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
            edta = findViewById(R.id.edta);
            edtkq = findViewById(R.id.edtkq);
            btnrequest = findViewById(R.id.btnrequest);
            //xử lí Click
            btnrequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myintent = new Intent(main_2.this, xuly2.class);
                    int a=Integer.parseInt(edta.getText().toString());
                    //đưa dữ liệu vào intent
                    myintent.putExtra("soa", a);
                    //khởi động
                    startActivityForResult(myintent, 99);
                }

            });

        }
//nhan kết quả từ xuly2 qua onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33) {
            int kq = data.getIntExtra("kq", 0);
            edtkq.setText( "Giá trị gốc là: "+kq);
        }
        if (requestCode == 99 && resultCode == 34) {
            int kq = data.getIntExtra("kq", 0);
            edtkq.setText( "Giá trị bình phương là: "+kq);
        }
    }
}
