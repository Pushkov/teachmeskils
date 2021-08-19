package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {


}
