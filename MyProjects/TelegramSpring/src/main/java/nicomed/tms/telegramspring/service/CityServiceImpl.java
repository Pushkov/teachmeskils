package nicomed.tms.telegramspring.service;

import lombok.AllArgsConstructor;
import nicomed.tms.telegramspring.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository repository;

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }

    @Override
    public City findCityByName(String name) {
        return repository.findCityByName(name).orElse(null);
    }
}
