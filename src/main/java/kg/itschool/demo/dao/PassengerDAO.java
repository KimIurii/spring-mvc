package kg.itschool.demo.dao;

import kg.itschool.demo.dao.dto.RegistrationDTO;
import kg.itschool.demo.entity.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDAO {

    void addPassenger(RegistrationDTO registrationDTO);

    default void method(){
        throw new UnsupportedOperationException();
    }
}
