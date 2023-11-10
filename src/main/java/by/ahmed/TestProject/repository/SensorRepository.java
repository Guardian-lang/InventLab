package by.ahmed.TestProject.repository;

import by.ahmed.TestProject.entity.Sensor;
import by.ahmed.TestProject.entity.Type;
import by.ahmed.TestProject.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByNameAndModelAndTypeAndUnit(String name, String model, Type type, Unit unit);
    List<Sensor> findAllByAdminUsername(String username);
}
