package com.example.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtmalop, edtten, edtsiso;
    Button btnins, btndel, btnupd, btnquery;
    ListView lv;
    ArrayList<String> mylist;
    ArrayAdapter<String> myadapter;
    SQLiteDatabase mydatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtmalop = findViewById(R.id.edtmalop);
        edtten = findViewById(R.id.edtten);
        edtsiso = findViewById(R.id.edtsiso);
        btnins = findViewById(R.id.btnins);
        btndel = findViewById(R.id.btndel);
        btnupd = findViewById(R.id.btnupd);
        btnquery = findViewById(R.id.btnquery);
        lv = findViewById(R.id.lv);

        //tạo listview
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

        //tạo và mo sqlite
        mydatabase = openOrCreateDatabase("qlsinhvien.db", MODE_PRIVATE, null); //tên file lưu dl
        //tạo table chứa dl
        try {
            String sql = "CREATE TABLE tbllop(malop TEXT PRIMARY KEY, tenlop TEXT, siso INTEGER)";
            mydatabase.execSQL(sql);
        } catch (Exception e) {
            Log.e("Error", "table đã tôn tại");
        }
        //thêm sự kiện cho button
        btnins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtmalop.getText().toString();
                String tenlop = edtten.getText().toString();
                int siso = Integer.parseInt(edtsiso.getText().toString());

                //tạo bảng ghi
                ContentValues myvalue = new ContentValues();
                myvalue.put("malop", malop);
                myvalue.put("tenlop", tenlop);
                myvalue.put("siso", siso);

                String msg = "";
                if (mydatabase.insert("tbllop", null, myvalue) == -1) {
                    msg = "Fail to insert record!";
                } else {
                    msg = "Insert record Sucessfully";

                }
                //thông báo lên
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }

        });


        //btn xóa
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String malop = edtmalop.getText().toString();
                int n = mydatabase.delete("tbllop", "malop=?", new String[]{malop});

                //thông báo
                String msg = "";
                if (n == 0) {
                    msg = "No record to delete";
                } else {
                    msg = n + " record deleted";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        btnupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int siso = Integer.parseInt(edtsiso.getText().toString());
                String malop = edtmalop.getText().toString();

                ContentValues myvalue = new ContentValues();
                myvalue.put("siso", siso);
                //update
                int n = mydatabase.update("tbllop", myvalue, "malop=?", new String[]{malop});

                //thông báo
                String msg = "";
                if (n == 0) {
                    msg = "No record to update";
                } else {
                    msg = n + " record updated";
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        //btn truy vấn
        btnquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist.clear();

                //con trỏ
                Cursor c = mydatabase.query("tbllop", null, null, null, null, null, null);
                c.moveToNext();
                String data= "";
                while (!c.isAfterLast()==false) {
                    data = c.getString(0) + " -" + c.getString(1) + " -" + c.getInt(2);
                    c.moveToNext();
                    mylist.add(data);
                }
                c.close();
                myadapter.notifyDataSetChanged();
            }
        });
    }
}