package com.example;

/**
 * Created by Administrator on 2016-09-28.
 */
public class Wine {
    public final String name;
    public final int artnum;
    public final int year;
    public final int price;
    public final int rating;


    public Wine(String name, int artnum, int year, int price, int rating) {
        this.name = name;
        this.artnum = artnum;
        this.year = year;
        this.price = price;
        this.rating = rating;
    }
}
