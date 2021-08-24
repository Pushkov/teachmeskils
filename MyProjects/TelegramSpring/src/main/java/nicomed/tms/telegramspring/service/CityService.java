package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.model.City;

import java.util.List;

public interface CityService {
    City findCityByName(String name);

    List<City> findAllCities();

    boolean addCity(String cityName);

    boolean editCity(String cityName);

    boolean removeCity(String cityName);
}
