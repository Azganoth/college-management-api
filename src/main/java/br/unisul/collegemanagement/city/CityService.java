package br.unisul.collegemanagement.city;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CityService {

    private final CityRepository cityRepository;

    public City retrieveById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    public List<City> retrieveAll() {
        return cityRepository.findAll();
    }

    public List<City> retrieveAllByStateId(Integer id) {
        return cityRepository.findAllByState_Id(id);
    }

}
