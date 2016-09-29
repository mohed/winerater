package com.example;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-09-28.
 */

@Component
public class SQLWineRepository implements WineRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Wine> listWines() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM [dbo].[Products] ")) {
            List<Wine> wines = new ArrayList<>();
            while (rs.next()) wines.add(rsWine(rs));
            return wines;
        } catch (SQLException e) {
            throw new WineRepositoryException(e);
        }
    }

    @Override
    public Wine getWine(long artnum) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT ProductID, Name FROM [dbo].[Products] WHERE ProductID = ?")) {
            ps.setLong(1, artnum);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new WineRepositoryException("No wine with ID " + artnum);
                else return rsWine(rs);
            }
        } catch (SQLException e) {
            throw new WineRepositoryException(e);
        }
    }


    private Wine rsWine(ResultSet rs) throws SQLException {
        return new Wine(rs.getLong("ProductID"), rs.getString("ProductName"));
    }
}