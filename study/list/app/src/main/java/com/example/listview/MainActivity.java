package com.example.listview;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declare fields (class-level variables) and initialize them
    int[] image = {R.drawable.iphone, R.drawable.samsung, R.drawable.oppo, R.drawable.vivo, R.drawable.xiaomi};
    String[] name = {"Iphone", "Samsung", "Oppo", "Vivo", "Xiaomi"};
    //khai báo listview
    ArrayList<phone> mylist;
    MyArrayAdaper myadaper;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ id
        lv = findViewById(R.id.listView);
        //khởi tạo mảng dl rỗng
        mylist = new ArrayList<>();
        //add 2 mảng con vào mảng rỗng
        for (int i = 0; i < name.length; i++) {
            mylist.add(new phone(image[i], name[i]));
        }
        //tạo mới adapter
        myadaper = new MyArrayAdaper(MainActivity.this, mylist, R.layout.activity_item);
        lv.setAdapter(myadaper);
        //xử lý click
        lv.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myintent = new Intent(MainActivity.this, SubActivity.class);
                myintent.putExtra("name", name[i]);
                startActivity(myintent);
            }

        }));
    }
}