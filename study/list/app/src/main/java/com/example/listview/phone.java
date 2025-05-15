package com.example.listview;
//đinh nghĩa doi tượng cho mảng dl
public class phone {
    //khai bao
    private int image;
    private String name;

    // genarate ->setter getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


//genarate ->constructor:
    public phone(int image, String name) {
        this.image = image;
        this.name = name;
    }
}
