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


@Component
public class SQLWineRepository implements WineRepository {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Wine> listWines(int articlenumber) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT TOP 2 P.ProductID, P.ProductName, P.Price, P.Year, P.Rating " +
                     "FROM Products AS P " +
                     "INNER JOIN Countries AS C " +
                     "ON P.Country_ID = C.CountryID " +
                     "WHERE C.Country = (SELECT CC.Country FROM Countries AS CC INNER JOIN Products AS PP ON CC.CountryID = PP.Country_ID WHERE PP.ProductID = ?) " +
                     "AND P.ProductID != ? " +
                     "ORDER BY P.Rating DESC")) {
            ps.setInt(1, articlenumber);
            ps.setInt(2, articlenumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.isBeforeFirst()) throw new WineRepositoryException("Inget vin");
                else {
                    List<Wine> wines = new ArrayList<>();
                    while (rs.next()) wines.add(rsWine(rs));
                    return wines;
                }
            }

        } catch (SQLException e) {
            throw new WineRepositoryException(e);
        }
    }

    private Wine rsWine(ResultSet rs) throws SQLException {
        return new Wine(rs.getString("ProductName"), rs.getInt("ProductID"), rs.getInt("Year"), rs.getInt("Price"), rs.getInt("Rating"));
    }
}