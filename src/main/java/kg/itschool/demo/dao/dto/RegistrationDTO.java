package kg.itschool.demo.dao.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
public class RegistrationDTO {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private String email;
    private String userName;
    private String password;
    private String phoneNumber;
    private Date birthDate;
    private String sex;
    private String passportDetails;
    private String userRole;
    private Long flightId;
}
