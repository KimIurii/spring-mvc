package kg.itschool.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public interface ConnectionDetails {

    String PASSWORD = "4b34543515bc311e15bda7f4cf056bdf593bf046ea893f878ae4fc830245a543";
    String USERNAME = "njmvhayozbzlox";
    String URl = "jdbc:postgresql://ec2-54-155-87-214.eu-west-1.compute.amazonaws.com:5432/d647ao85hj8qfs";;

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URl,USERNAME,PASSWORD);
    }

}
