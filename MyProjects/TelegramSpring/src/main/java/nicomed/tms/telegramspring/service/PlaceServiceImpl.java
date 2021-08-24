package nicomed.tms.telegramspring.service;

import nicomed.tms.telegramspring.model.City;
import nicomed.tms.telegramspring.model.Place;
import nicomed.tms.telegramspring.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository repository;

    public PlaceServiceImpl(PlaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Place> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Place> findAllByCity(City city) {
        return repository.findAllByCity(city);
    }
}
