package kg.itschool.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Passenger {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private String phoneNumber;
    private Date birthDate;
    private String sex;
    private String passportDetails;
    private String userRole;
}
