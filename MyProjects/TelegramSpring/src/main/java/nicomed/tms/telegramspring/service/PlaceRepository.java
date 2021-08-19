package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByCity(City city);
}
