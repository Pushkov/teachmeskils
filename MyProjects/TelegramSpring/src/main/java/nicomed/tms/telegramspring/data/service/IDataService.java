package nicomed.tms.telegramspring.data.service;

import nicomed.tms.telegramspring.data.enums.Grade;
import nicomed.tms.telegramspring.data.model.City;
import nicomed.tms.telegramspring.data.model.Place;

import java.util.List;

public interface IDataService {

    City findCityByName(String name);

    List<City> findAllCities();

    boolean addCity(String cityName);

    boolean editCity(String cityName);

    boolean removeCity(String cityName);

    Place findPlaceById(Long id);

    Place findPlaceByName(String name);

    List<Place> findAllPlaces();
    List<Place> findAllPlacesByCity(City city);
    List<Place> findAllPlacesByCityName(String cityName);
    boolean addPlace(String placeName, Grade drade);
    boolean editPlace(String placeName);
    boolean removePlace(String placeName);

    boolean addPlaceToCity(Place place, City city);
    boolean removePlaceFromCity(Place place, City city);
}
