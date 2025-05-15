package com.example.hoc_sqlite;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
public class main extends AppCompatActivity {
    //Khai báo các biến
    String DB_PATH_SUFFIX = "/databases/"; //Thư mục chứa CSDL (mặc đinh)
    SQLiteDatabase database=null; //Khai báo CSDL
    String DATABASE_NAME="qlsach.db"; //Tên CSDL
    //Khai báo ListView
    ListView lv;
    ArrayList<String> mylist; //mảng dl
    ArrayAdapter<String> myadapter;//adapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthi_sql);

// Tạo các tham số của ListView
        lv = findViewById(R.id.lv);
        mylist = new ArrayList<>();
        myadapter = new ArrayAdapter<>(main.this,
                android.R.layout.simple_list_item_1, mylist);
        lv.setAdapter(myadapter);

//Gọi hàm Copy CSDL từ assets vào thư mục Databases trong bộ nhớ cài đặt
        processCopy();

//Mở CSDL lên để dùng
        database = openOrCreateDatabase("qlsach.db",MODE_PRIVATE, null);

// Truy vấn CSDL và cập nhật hiển thị lên Listview
        Cursor c = database.query("tbsach",null,null,null,null,null,null);
        c.moveToFirst();
        String data =""; //để chứa dl
        while (c.isAfterLast() == false)//nếu con trỏ chưa ở cuối
        {
            //các cột trong bảng
            data = c.getString(0)+"-"+c.getString(1)+"-"+c.getString(2);
            //Thêm dl vào mảng
            mylist.add(data);
            //Di chuyển con trỏ xuống bản ghi tiếp theo
            c.moveToNext();
        }
        c.close();
        //Cập nhật lại ListView
        myadapter.notifyDataSetChanged();
    }


    //hàm copy CSDL từ assets vào thư mục Databases (thư muc cài đặt ứng dụng)
    private void processCopy() {
//private app
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists())
        {
            try{CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }
    public void CopyDataBaseFromAsset() {
// TODO Auto-generated method stub
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);
// Path to the just created empty db
            String outFileName = getDatabasePath();
// if the path doesn't exist first, create it
            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();
// Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);
// transfer bytes from the inputfile to the outputfile
// Truyền bytes dữ liệu từ input đến output
            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutput.write(buffer);
// Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}