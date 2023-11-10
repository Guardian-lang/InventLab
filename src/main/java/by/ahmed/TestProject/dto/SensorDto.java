package by.ahmed.TestProject.dto;

import by.ahmed.TestProject.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDto {
    Integer id;
    String name;
    String model;
    Integer min;
    Integer max;
    String type;
    String unit;
    String location;
    String description;
    User admin;
}
