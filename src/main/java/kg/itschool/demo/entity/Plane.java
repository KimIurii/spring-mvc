package kg.itschool.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "tb_planes")
@Data
@NoArgsConstructor
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NotNull
    private String company;

    @Column
    @NotNull
    private String model;

    @Column
    @NotNull
    private Integer seats;
}
