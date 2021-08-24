package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.enums.Grade;
import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;

import java.util.List;

public interface DataService {

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
