package com.example;

/**
 * Created by Administrator on 2016-09-28.
 */
public class Wine {
    private String name;
    private int artnum;

    public Wine(String name, int artnum) {
        this.name = name;
        this.artnum = artnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtnum() {
        return artnum;
    }

    public void setArtnum(int artnum) {
        this.artnum = artnum;
    }
}
