package by.ahmed.TestProject.service;

import by.ahmed.TestProject.dto.UserDto;
import by.ahmed.TestProject.mapper.UserMapper;
import by.ahmed.TestProject.repository.UserRepository;
import by.ahmed.TestProject.validator.LoginUserValidator;
import by.ahmed.TestProject.validator.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final LoginUserValidator loginUserValidator;

    public Optional<UserDto> login(String username, String password) {
        var user = userRepository.findAll()
                .stream()
                .filter(it -> it.getUsername()
                        .equals(username)
                        && it.getPassword().equals(password))
                .findFirst()
                .orElseThrow();
        var userDto = Optional.of(userMapper.toDto(user));
        var validationResult = loginUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        return userDto;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAuthorities()
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + username));
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto);
    }

    public Optional<UserDto> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userMapper::toDto);
    }

    @Transactional
    public UserDto create(UserDto userDto) {
        return Optional.of(userDto)
                .map(userMapper::toUser)
                .map(userRepository::save)
                .map(userMapper::toDto)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserDto> update(Long id, UserDto userDto) {
        return userRepository.findById(id)
                .map(entity -> userMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userMapper::toDto);
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
