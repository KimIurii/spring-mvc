package kg.itschool.demo.dao.impl;

import kg.itschool.demo.dao.PlaneDAO;
import kg.itschool.demo.entity.Plane;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

@Repository
public class PlaneDAOImpl implements PlaneDAO {
    private Connection connection;
    private Logger logger;
    {
        logger = Logger.getLogger(this.getClass().getName());
        try {
            Class.forName("org.postgresql.Driver");
            logger.info("PostgreSQL Driver loaded");
        }catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        String password = "4b34543515bc311e15bda7f4cf056bdf593bf046ea893f878ae4fc830245a543";
        String username = "njmvhayozbzlox";
        String url = "jdbc:postgresql://ec2-54-155-87-214.eu-west-1.compute.amazonaws.com:5432/d647ao85hj8qfs";

        return DriverManager.getConnection(url,username,password);
    }


    @Override
    public void addPlane(Plane plane) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String query = "INSERT INTO planes(company,model,seats)"+
                "VALUES(?,?,?)";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, plane.getCompany());
            preparedStatement.setString(2,plane.getModel());
            preparedStatement.setInt(3,plane.getSeats());
            preparedStatement.executeUpdate();

        }catch (SQLException exception){
            exception.printStackTrace();
        }finally {
            closeConnection(preparedStatement);
            closeConnection(connection);
        }
    }

    private void closeConnection(AutoCloseable autoCloseable){
        try{
            autoCloseable.close();
            logger.info(autoCloseable.getClass().getName()+" closed");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
