package by.ahmed.TestProject.service;

import by.ahmed.TestProject.dto.SensorDto;
import by.ahmed.TestProject.entity.Type;
import by.ahmed.TestProject.entity.Unit;
import by.ahmed.TestProject.mapper.SensorMapper;
import by.ahmed.TestProject.repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorService {
    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public Optional<SensorDto> findById(Integer id) {
        return sensorRepository.findById(id)
                .map(sensorMapper::toDto);
    }

    public Optional<SensorDto> findByNameAndModelAndTypeAndUnit(String name, String model, Type type, Unit unit) {
        return sensorRepository.findByNameAndModelAndTypeAndUnit(name, model, type, unit)
                .map(sensorMapper::toDto);
    }

    public List<SensorDto> findAllByUser(String username) {
        return sensorRepository.findAllByAdminUsername(username).stream()
                .map(sensorMapper::toDto)
                .toList();
    }
}
