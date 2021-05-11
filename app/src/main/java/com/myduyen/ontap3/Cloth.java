package com.myduyen.ontap3;

import java.io.Serializable;

public class Cloth implements Serializable {
    private int anh;
    private String name;
    private int price;
    private int anhNguoi,soLuong;
    private String size;


    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAnhNguoi() {
        return anhNguoi;
    }

    public void setAnhNguoi(int anhNguoi) {
        this.anhNguoi = anhNguoi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Cloth(int anh, String name, int price, int anhNguoi, int soLuong, String size) {
        this.anh = anh;
        this.name = name;
        this.price = price;
        this.anhNguoi = anhNguoi;
        this.soLuong = soLuong;
        this.size = size;
    }
}
