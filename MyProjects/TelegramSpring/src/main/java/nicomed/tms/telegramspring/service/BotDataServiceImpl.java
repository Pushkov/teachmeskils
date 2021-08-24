package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.enums.Grade;
import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;
import nicomed.tms.telegramspring.repository.CityRepository;
import nicomed.tms.telegramspring.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotDataServiceImpl implements DataService {
    private final CityRepository cityRepository;
    private final PlaceRepository placeRepository;

    public BotDataServiceImpl(CityRepository cityRepository, PlaceRepository placeRepository) {
        this.cityRepository = cityRepository;
        this.placeRepository = placeRepository;
    }


    @Override
    public City findCityByName(String name) {
        return cityRepository.findCityByName(name).orElse(null);
    }

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public boolean addCity(String cityName) {
        cityRepository.save(new City(cityName));
        return true;
    }

    @Override
    public boolean editCity(String cityName) {

        return false;
    }

    @Override
    public boolean removeCity(String cityName) {
        City city = cityRepository.findCityByName(cityName).orElse(null);
        if (city != null) {
            cityRepository.delete(city);
            return true;
        }
        return false;
    }

    @Override
    public Place findPlaceById(Long id) {
        return placeRepository.getById(id);
    }

    @Override
    public Place findPlaceByName(String name) {
        return placeRepository.findPlaceByName(name).orElse(null);
    }

    @Override
    public List<Place> findAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public List<Place> findAllPlacesByCity(City city) {
        return placeRepository.findAllByCity(city);
    }

    @Override
    public List<Place> findAllPlacesByCityName(String cityName) {
        City city = findCityByName(cityName);
        if (city != null) {
            return findAllPlacesByCity(city);
        }
        return null;
    }

    @Override
    public boolean addPlace(String placeName, Grade grade) {
        placeRepository.save(new Place(placeName, grade));
        return true;
    }

    @Override
    public boolean editPlace(String placeName) {
        return false;
    }

    @Override
    public boolean removePlace(String placeName) {
        Place place = findPlaceByName(placeName);
        if (place != null) {
            placeRepository.delete(place);
            return true;
        }
        return false;
    }

    @Override
    public boolean addPlaceToCity(Place place, City city) {
        city.getPlaces().add(place);
        return true;
    }

    @Override
    public boolean removePlaceFromCity(Place place, City city) {
        city.getPlaces().remove(place);
        return true;
    }
}
