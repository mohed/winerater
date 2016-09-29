package com.example;

import java.util.List;

/**
 * Created by Administrator on 2016-09-28.
 */
public interface WineRepository {
    List<Wine> listWines();
    Wine getWine(long artnum);
}
