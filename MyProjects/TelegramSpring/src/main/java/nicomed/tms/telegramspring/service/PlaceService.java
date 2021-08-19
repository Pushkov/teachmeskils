package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;

import java.util.List;

public interface PlaceService {
    List<Place> findAll();

    List<Place> findAllByCity(City city);

}
