package by.ahmed.TestProject.mapper;

import by.ahmed.TestProject.dto.SensorDto;
import by.ahmed.TestProject.entity.Sensor;
import by.ahmed.TestProject.entity.Type;
import by.ahmed.TestProject.entity.Unit;
import org.springframework.stereotype.Component;

@Component
public class SensorMapper {
    public Sensor toSensor(SensorDto dto) {
        if (dto == null) {
            return null;
        }
        else {
            return new Sensor(
                    dto.getId(),
                    dto.getName(),
                    dto.getModel(),
                    dto.getMin(),
                    dto.getMax(),
                    Type.valueOf(dto.getType()),
                    Unit.valueOf(dto.getUnit()),
                    dto.getLocation(),
                    dto.getDescription(),
                    dto.getAdmin()
            );
        }
    }

    public SensorDto toDto(Sensor sensor) {
        if (sensor == null) {
            return null;
        }
        else {
            return new SensorDto(
                    sensor.getId(),
                    sensor.getName(),
                    sensor.getModel(),
                    sensor.getMin(),
                    sensor.getMax(),
                    String.valueOf(sensor.getType()),
                    String.valueOf(sensor.getUnit()),
                    sensor.getLocation(),
                    sensor.getDescription(),
                    sensor.getAdmin());
        }
    }
}
