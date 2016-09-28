package com.example;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2016-09-28.
 */
public class SQLWineRepository implements WineRepository {
    private final Connection connection;

    public SQLWineRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Wine> getWines(int artnum, String name) {
        return null;
    }
}
