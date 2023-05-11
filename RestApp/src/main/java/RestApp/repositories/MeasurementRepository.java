package RestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import RestApp.models.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

}
