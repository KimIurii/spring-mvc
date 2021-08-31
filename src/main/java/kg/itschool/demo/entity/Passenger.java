package kg.itschool.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="tb_passengers")
@Data
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private Date birthDate;

    @Column
    private String sex;

    @Column
    private String passportDetails;

    @Column
    private String userRole;
}
