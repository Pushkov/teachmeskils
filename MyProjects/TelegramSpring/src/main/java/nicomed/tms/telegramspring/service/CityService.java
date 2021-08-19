package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.model.City;

import java.util.List;

public interface CityService {
    List<City> findAll();

    City findCityByName(String name);
}
