package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//thiết kế lại adapter thừa kế kiểu phone đã được định nghĩa
public class MyArrayAdaper  extends ArrayAdapter<phone> {
    Activity context;
    int Idlayout;
    ArrayList<phone> mylist;
    //tạo constructor để mainactivity gọi đến và truyen cac tham số vào
    public MyArrayAdaper(Activity context, ArrayList<phone> mylist, int idlayout) {
        super(context, idlayout,mylist);
        this.context = context;
        this.mylist = mylist;
        Idlayout = idlayout;
    }
    //hiển thị dl (gọi hàm getview để tiến hành sắp xếp dl

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //tạo đế chứa layout
        LayoutInflater myflater = context.getLayoutInflater();
        //đặt idlayout lên đế để tạo thành 1 đốtuowtuong view
        convertView = myflater.inflate(Idlayout,null);
        //lấy 1 phần tử trong mảng
        phone myphone = mylist.get(position);//position là vị trí, tăng tu 0-vi trí cuối cùng
        //khai báo , tham chiếu id và hiển thị ảnh
        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(myphone.getImage());
        //khai báo, tham chiếu id và hiển thị tên dt lên list
        TextView textView = convertView.findViewById(R.id.textView2);
        textView.setText(myphone.getName());
        return convertView; //trả về để hiển thị lên listview
    }
}
