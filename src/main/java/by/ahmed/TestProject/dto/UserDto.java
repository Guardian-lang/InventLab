package by.ahmed.TestProject.dto;

import by.ahmed.TestProject.entity.Sensor;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Long id;
    String role;
    String username;
    String password;
    List<Sensor> sensors;
}
