package by.ahmed.TestProject.mapper;

import by.ahmed.TestProject.dto.UserDto;
import by.ahmed.TestProject.entity.Role;
import by.ahmed.TestProject.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserDto dto) {
        if (dto == null) {
            return null;
        }
        else {
            return new User(
                    dto.getId(),
                    Role.valueOf(dto.getRole()),
                    dto.getUsername(),
                    dto.getPassword(),
                    dto.getSensors()
            );
        }
    }

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        else {
            return new UserDto(
                    user.getId(),
                    String.valueOf(user.getRole()),
                    user.getUsername(),
                    user.getPassword(),
                    user.getSensors()
            );
        }
    }

    public User map(UserDto userDto, User user) {
        user.setId(userDto.getId());
        user.setRole(Role.valueOf(userDto.getRole()));
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setSensors(userDto.getSensors());

        return user;
    }
}
