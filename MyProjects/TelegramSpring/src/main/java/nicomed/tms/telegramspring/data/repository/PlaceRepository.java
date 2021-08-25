package nicomed.tms.telegramspring.data.repository;

import nicomed.tms.telegramspring.data.model.City;
import nicomed.tms.telegramspring.data.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByCity(City city);
    Optional<Place> findPlaceByName(String name);
}
