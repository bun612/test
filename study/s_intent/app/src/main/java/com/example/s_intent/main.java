package com.example.s_intent;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class main extends AppCompatActivity {
    EditText txta, txtb;
    Button btngiai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_a);
        //ánh xạ
        txta = findViewById(R.id.txta);
        txtb = findViewById(R.id.txtb);
        btngiai = findViewById(R.id.btngiai);
        //xử lý click
        btngiai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            //khai báo intent
                Intent myintent = new Intent(main.this, result.class);
            //lấy dữ liệu
                int a = Integer.parseInt(txta.getText().toString());
                int b = Integer.parseInt(txtb.getText().toString());
                //khai báo bundle
                Bundle mybundle = new Bundle();
                //đưa dữ liệu vào bundel
                mybundle.putInt("soa",a);
                mybundle.putInt("sob",b);
                //đưa bundel vào intent
                myintent.putExtra("mypackage",mybundle);
                //chuyển màn hình
                startActivity(myintent);

        }
    });
    }
}
