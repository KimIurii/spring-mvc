package kg.itschool.demo.dao.impl;

import kg.itschool.demo.dao.ConnectionDetails;
import kg.itschool.demo.dao.PassengerDAO;
import kg.itschool.demo.dao.dto.RegistrationDTO;
import kg.itschool.demo.entity.Passenger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    private Log log;

    static{
        try{
            Class.forName("org.postgresql.Driver");

        }catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    {
        log = LogFactory.getLog(getClass().getName());
    }

    @Override
    public void addPassenger(RegistrationDTO registrationDTO) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;

        String query = ""+
                "INSERT INTO passengers(first_name, last_name, email, user_name, password, phone_number, birth_date, sex, passport_details, user_role)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String queryTwo = "INSERT INTO flights_has_passengers(flight_id,passenger_id) VALUES (?,)";

        try{
            connection = ConnectionDetails.getConnection();
            log.info(connection.getClass().getSimpleName() + " created,");
            preparedStatement = connection.prepareStatement(query);
            log.info(preparedStatement.getClass().getSimpleName()+ " created.");

            preparedStatement.setString(1,registrationDTO.getFirstName());
            preparedStatement.setString(2,registrationDTO.getLastName());
            preparedStatement.setString(3,registrationDTO.getEmail());/////
            preparedStatement.setString(4, registrationDTO.getEmail());///
            preparedStatement.setString(5, "1234");
            preparedStatement.setString(6, registrationDTO.getPhoneNumber());
            preparedStatement.setDate(7, new Date(registrationDTO.getBirthDate().getTime()));
            preparedStatement.setString(8, registrationDTO.getSex());
            preparedStatement.setString(9, registrationDTO.getPassportDetails());
            preparedStatement.setString(10, "USER");

            preparedStatement.executeUpdate();

            statement = connection.createStatement();
            log.info(statement.getClass().getSimpleName()+ " created");
            statement.executeUpdate(queryTwo);

        }catch (SQLException exception){
            log.error(exception.getCause()+". Check stacktrace below.");
            exception.printStackTrace();
        }finally {
            closeConnection(preparedStatement);
            closeConnection(statement);
            closeConnection(connection);
        }

    }

    private void closeConnection(AutoCloseable closeable){
        try{
            closeable.close();
            log.info(closeable.getClass().getSimpleName() + " closed.");
        }catch (Exception e){
            log.error(closeable.getClass().getSimpleName() + " could not closed. Check stacktrace below.");
            e.printStackTrace();
        }
    }


}
