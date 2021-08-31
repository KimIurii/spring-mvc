package kg.itschool.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Plane {
    private Long id;
    @NotNull
    private String company;
    @NotNull
    private String model;
    @NotNull
    private Integer seats;
}
