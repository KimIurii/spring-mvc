package kg.itschool.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public interface ConnectionDetails {

    String PASSWORD = "woshiyouli10";
    String USERNAME = "postgres";
    String URl = "jdbc:postgresql://localhost:5432/postgres";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URl,USERNAME,PASSWORD);
    }

}
